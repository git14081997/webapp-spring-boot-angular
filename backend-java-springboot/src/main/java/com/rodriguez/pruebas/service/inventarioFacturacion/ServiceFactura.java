
// linea de 79 de largo
//////////////////////////////////////////////////////////////////////////////
//

package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ClienteAbona;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Factura;
import com.rodriguez.pruebas.entity.inventarioFacturacion.FacturaDetalle;
import com.rodriguez.pruebas.entity.inventarioFacturacion.IngresosEgresos;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Inventario;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaDetalleRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.IngresosEgresosRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.InventarioRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ProductoRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ServiceFactura implements IServiceFactura {

	private static final Logger log = LoggerFactory.getLogger(ServiceFactura.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private FacturaRepository facturaRepository;

	@Autowired
	private FacturaDetalleRepository facturaDetalleRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private InventarioRepository inventarioRepository;

	@Autowired
	private ClienteAbonaRepository clienteAbonaRepository;

	@Autowired
	private IngresosEgresosRepository ingresosEgresosRepository;


	private final String ERROR = "error";

	private final String INF = "inf";

	private final BigDecimal cero = new BigDecimal(0);



@Transactional(
	rollbackFor = {
		RuntimeException.class,
		Exception.class,
		IllegalArgumentException.class,
		NoSuchElementException.class
	}
)
@Override
public Map<String, Object> anularFactura( Integer facturaid ) {


	Map<String, Object> resultado = new HashMap<>();
	Factura pedidoIncorrectoSeraAnulado = null;

	boolean pedidoAlCredito = false;
	boolean pedidoEnEfectivo = false;

	String tipoDePago = "";
	BigDecimal totalDelPedido = null;

	final Date fechaAnulacion = new Date();



	if( facturaid == null )
	{
		resultado.put( ERROR, "facturaId es null !");
		resultado.put( INF, HttpStatus.INTERNAL_SERVER_ERROR.value() );
		return resultado;
	}

	Optional<Factura> optionalFactura =
		facturaRepository.findById( facturaid );

	if( optionalFactura.isEmpty() )
	{
		resultado.put( ERROR, "facturaId es null !");
		resultado.put( INF, HttpStatus.INTERNAL_SERVER_ERROR.value() );
		return resultado;
	}

	pedidoIncorrectoSeraAnulado = optionalFactura.get();



	tipoDePago = pedidoIncorrectoSeraAnulado.getTipoPago();



	if( tipoDePago.equalsIgnoreCase("C") )
	{
		pedidoAlCredito = true;
	}

	if( tipoDePago.equalsIgnoreCase("E") )
	{
		pedidoEnEfectivo = true;
	}


	if( !pedidoAlCredito && !pedidoEnEfectivo ) {
		resultado.put( ERROR, "Solo puedes anular pedidos al credito o en efetivo !");
		resultado.put( INF, HttpStatus.INTERNAL_SERVER_ERROR.value() );
		return resultado;
	}




	Optional<Usuario> optionalUsuario = usuarioRepository.findById(
		pedidoIncorrectoSeraAnulado.getCliente().getId()
	);

	if( optionalUsuario.isEmpty() )
	{
		resultado.put( ERROR, "No hay usuario con el mismo ID !");
		resultado.put( INF, HttpStatus.INTERNAL_SERVER_ERROR.value() );
		return resultado;
	}




	totalDelPedido = pedidoIncorrectoSeraAnulado.getTotal();











	// comienzan las modificaciones
	// si algo falla a partir de este punto
	// sera mejor anular toda la transaccion
	// arrojando una excepcion !

	List<FacturaDetalle> detallesPorFactura =
		facturaDetalleRepository.findByFactura( pedidoIncorrectoSeraAnulado );

	Producto productoDB_N = null;

	Optional<Producto> optionalProducto;

	for( FacturaDetalle detalleN : detallesPorFactura )
	{

		optionalProducto = productoRepository.findById(
			detalleN.getProducto().getId()
		);

		if( optionalProducto.isEmpty() )
		{
			throw new NoSuchElementException("No existe el producto con ID ");
		}

		productoDB_N = optionalProducto.get();

		this.agregarExistencias( productoDB_N, detalleN.getCantidadProductoVendido() );

	} // analizando detalles del pedido






	// marcando pedido como anulado !
	pedidoIncorrectoSeraAnulado.setTipoPago("A");
	pedidoIncorrectoSeraAnulado.setFechaAnulacion( fechaAnulacion );
	pedidoIncorrectoSeraAnulado = facturaRepository.save(pedidoIncorrectoSeraAnulado);
	// marcando pedido como anulado !








	// actualizar el saldo,
	// reducir saldo pendiente de pago del cliente
	if( pedidoIncorrectoSeraAnulado.getTipoPago().equalsIgnoreCase("C") )
	{
		BigDecimal nuevoSaldo;
		BigDecimal saldoPendienteDePago;

		Usuario usuarioQueHizoElPedido = pedidoIncorrectoSeraAnulado.getCliente();

		Optional<Usuario> usuarioOptional =
			usuarioRepository.findById(usuarioQueHizoElPedido.getId());

		if( usuarioOptional.isEmpty() ) {
			resultado.put(ERROR, "No existe cliente");
			resultado.put(INF, HttpStatus.INTERNAL_SERVER_ERROR.value());
			return resultado;
		}


		Usuario usuarioDB = usuarioOptional.get();

		saldoPendienteDePago = usuarioDB.getPendienteDePago();

		nuevoSaldo = saldoPendienteDePago.subtract( totalDelPedido );

		usuarioDB.setPendienteDePago( nuevoSaldo  );

		usuarioDB = usuarioRepository.save( usuarioDB );




		ClienteAbona clienteAbona = new ClienteAbona();

		clienteAbona.setDetalles(
			"Se anula pedido " + pedidoIncorrectoSeraAnulado.getId()
			+ " ya que contiene errores."
		);

		clienteAbona.setFactura( pedidoIncorrectoSeraAnulado );

		clienteAbona.setCliente( usuarioDB );

		clienteAbona.setFecha( fechaAnulacion );

		clienteAbona.setSaldoAnterior( saldoPendienteDePago );

		clienteAbona.setCargos( cero );

		clienteAbona.setAbonos( totalDelPedido );

		clienteAbona.setSaldo( nuevoSaldo );

		clienteAbona = clienteAbonaRepository.save(clienteAbona);


	} // pedido al credito







	// si fue unPedido pagado en efectivo, se debe agregar un gasto por el monto total.
	if( pedidoIncorrectoSeraAnulado.getTipoPago().equalsIgnoreCase("E") )
	{
		IngresosEgresos ie = new IngresosEgresos();

		ie.setFecha( fechaAnulacion );

		ie.setDetalle(
			"Se anula pedido " + pedidoIncorrectoSeraAnulado.getId() + "." +
			"\nContiene uno o más errores." +
			"\nFue pedido con tipoPago: '" + pedidoIncorrectoSeraAnulado.getTipoPago() + "'."
		);

		ie.setEgresos(totalDelPedido);

		ie.setIngresos(cero);

		ie = ingresosEgresosRepository.save(ie);

	} // pedido en Efectivo



	resultado.put("msg", "Pedido " + facturaid + " anulado." );
	resultado.put( "fechaAnulacion", fechaAnulacion );
	resultado.put( INF, HttpStatus.OK.value() );

	return resultado;

} // anularFactura








	@Transactional
	public Inventario buscarUltimoRegistroDelInventarioDelProducto(Integer productoId)
	{
		String sql = """
		SELECT * FROM inventario WHERE producto_id = ? ORDER BY fecha DESC limit 1
		""";
		List<Inventario> registrosDelInventario = jdbcTemplate.query(
			sql, new BeanPropertyRowMapper<>(Inventario.class), productoId
		);

		return registrosDelInventario.get(0);
	} // buscarUltimoRegistroDelInventarioDelProducto




	@Transactional
	public void agregarExistencias( Producto productoDB, int nuevasUnidades )
	{
		productoDB.setExistencias( productoDB.getExistencias() + nuevasUnidades );

		productoDB = productoRepository.save(productoDB);

		agregarAlInventario( productoDB, nuevasUnidades );
	}



	@Transactional
	public void agregarAlInventario( Producto producto, Integer nuevasUnidades )
	{
		Inventario entradas_y_salidas = new Inventario();

		entradas_y_salidas.setFecha( new Date() );

		entradas_y_salidas.setProducto( producto );

		Inventario ultimoRegistroEntradaSalidas =
			buscarUltimoRegistroDelInventarioDelProducto( producto.getId() );

		entradas_y_salidas.setSaldoAnterior( ultimoRegistroEntradaSalidas.getExistencia() );

		entradas_y_salidas.setEntradas( nuevasUnidades );

		entradas_y_salidas.setSalidas(0);

		entradas_y_salidas.setExistencia(
			entradas_y_salidas.getSaldoAnterior() +
			entradas_y_salidas.getEntradas() -
			entradas_y_salidas.getSalidas()
		);

		inventarioRepository.save( entradas_y_salidas );
	}






	@Transactional
	public void abonarAlCliente( Usuario cliente, BigDecimal clientePaga, Factura factura, Date fechaAnulacion )
	{
		BigDecimal saldoAnterior = cliente.getPendienteDePago();

		BigDecimal nuevoSaldo = saldoAnterior.subtract( clientePaga );

		cliente.setPendienteDePago( nuevoSaldo  );

		cliente = usuarioRepository.save( cliente );

		registrarAbono(
			factura,
			cliente,
			fechaAnulacion,
			saldoAnterior,
			clientePaga
		);

	}




	@Transactional
	public void registrarAbono(
		Factura factura,
		Usuario cliente,
		Date fechaAnulacion,
		BigDecimal saldoAnterior,
		BigDecimal clientePaga
	)
	{
		ClienteAbona cargos_y_abonos = new ClienteAbona();

		cargos_y_abonos.setDetalles(
			"Se anula pedido " + factura.getId()
			+ "\nContiene errores."
		);

		cargos_y_abonos.setFactura( factura );

		cargos_y_abonos.setCliente( cliente );

		cargos_y_abonos.setFecha( fechaAnulacion );



		cargos_y_abonos.setSaldoAnterior( saldoAnterior );

		cargos_y_abonos.setCargos( cero );

		cargos_y_abonos.setAbonos( clientePaga );

		cargos_y_abonos.setSaldo( saldoAnterior.subtract( clientePaga ) );

		clienteAbonaRepository.save( cargos_y_abonos );
	}





	@Transactional
	public void registrarCargo(
	Factura factura,
	Usuario cliente,
	Date fecha,
	BigDecimal saldoAnterior,
	BigDecimal totalFactura
	)
	{
		ClienteAbona cargos_y_abonos = new ClienteAbona();

		cargos_y_abonos.setDetalles( "Cargo por pedido " + factura.getId() );

		cargos_y_abonos.setFactura( factura );

		cargos_y_abonos.setCliente( cliente );

		cargos_y_abonos.setFecha( fecha );

		cargos_y_abonos.setSaldoAnterior( saldoAnterior );

		cargos_y_abonos.setCargos( totalFactura );

		cargos_y_abonos.setAbonos( cero );

		cargos_y_abonos.setSaldo( saldoAnterior.add( totalFactura ) );

		clienteAbonaRepository.save( cargos_y_abonos );
	}



} // class
