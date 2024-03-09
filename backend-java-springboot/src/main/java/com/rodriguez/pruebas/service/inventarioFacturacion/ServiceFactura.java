
// linea de 79 de largo
//////////////////////////////////////////////////////////////////////////////
//

package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.ResumenDto;
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
import java.time.LocalDate;
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
	Factura pedidoIncorrecto = null;

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


	pedidoIncorrecto = optionalFactura.get();

	tipoDePago = pedidoIncorrecto.getTipoPago();


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
		pedidoIncorrecto.getCliente().getId()
	);

	if( optionalUsuario.isEmpty() )
	{
		resultado.put( ERROR, "No hay usuario con el mismo ID !");
		resultado.put( INF, HttpStatus.INTERNAL_SERVER_ERROR.value() );
		return resultado;
	}


	Usuario usuarioDB = optionalUsuario.get();

	totalDelPedido = pedidoIncorrecto.getTotal();

	String detallesPorAnulacion =
	"Se anula pedido " + pedidoIncorrecto.getId() + "." +
	"\nContiene uno o más errores." +
	"\nFue pedido con tipoPago: '" +
	pedidoIncorrecto.getTipoPago() +
	"'" + "\nFue anulado: " + fechaAnulacion.toString() ;



	// comienzan las modificaciones
	// si algo falla a partir de este punto
	// sera mejor anular toda la transaccion
	// arrojando una excepcion !

	List<FacturaDetalle> detallesPorFactura =
		facturaDetalleRepository.findByFactura( pedidoIncorrecto );

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



	if( tipoDePago.equalsIgnoreCase("C") )
	{
		abonarAlCliente(
			usuarioDB, totalDelPedido,
			pedidoIncorrecto,
			fechaAnulacion, detallesPorAnulacion
		);
	}



	if( tipoDePago.equalsIgnoreCase("E") )
	{
		registrarEgreso(
			totalDelPedido,
			fechaAnulacion,
			detallesPorAnulacion
		);
	}


	marcarFacturaComoAnulada( pedidoIncorrecto, fechaAnulacion );


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
	public void abonarAlCliente(
		Usuario cliente, BigDecimal clientePaga,
		Factura factura, Date fecha,
		String detalles
	) {
		BigDecimal saldoAnterior = cliente.getPendienteDePago();

		BigDecimal nuevoSaldo = saldoAnterior.subtract( clientePaga );

		cliente.setPendienteDePago( nuevoSaldo  );

		cliente = usuarioRepository.save( cliente );

		registrarAbono(
			factura, cliente, fecha,
			saldoAnterior, clientePaga, detalles
		);
	}



// abono normal cuando pagan
// vs abono cuando se anula
// agregar parametro detalles
	@Transactional
	public void registrarAbono(
		Factura factura,
		Usuario cliente,
		Date fechaAnulacion,
		BigDecimal saldoAnterior,
		BigDecimal clientePaga,
		String detalles
	)
	{
		ClienteAbona cargos_y_abonos = new ClienteAbona();

		cargos_y_abonos.setDetalles( detalles );

		String detallesPorAnulacion =
		"Se anula pedido " + factura.getId()
		+ "\nContiene errores.";

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



	@Transactional
	public void marcarFacturaComoAnulada(Factura factura, Date fechaAnulacion)
	{
		factura.setTipoPago("A");
		factura.setFechaAnulacion( fechaAnulacion );
		facturaRepository.save(factura);
	}



	@Transactional
	public void registrarEgreso(BigDecimal egreso, Date fecha, String detalles){

		IngresosEgresos ie = new IngresosEgresos();
		ie.setFecha( fecha );

		ie.setDetalle( detalles );

		/*
		ie.setDetalle(
		"Se anula pedido " + pedidoIncorrectoSeraAnulado.getId() + "." +
		"\nContiene uno o más errores." +
		"\nFue pedido con tipoPago: '" + pedidoIncorrectoSeraAnulado.getTipoPago() + "'."
		);
		*/

		ie.setEgresos(egreso);

		ie.setIngresos(cero);

		ie = ingresosEgresosRepository.save(ie);
	}



	@Transactional
	public void registrarIngreso(BigDecimal ingreso, Date fecha, String detalles){

		IngresosEgresos ie = new IngresosEgresos();

		ie.setFecha( fecha );

		ie.setDetalle( detalles );

		ie.setEgresos(cero);

		ie.setIngresos(ingreso);

		ie = ingresosEgresosRepository.save(ie);
	}



	@Override
	public Map<String, Object> resumen() {

		// fechaDesde formato
		// 2024-12-01 yyyy-mm-dd

		// fechaHasta
		// 2024-12-31


		Date dt = new Date();
		int year = dt.getYear();

		String currentYear = Integer.toString(year);

		String fi = currentYear + "-01-01";
		String ff = currentYear + "-12-31";

		Map<String, Object> resultado = new HashMap<>();

		resultado.put(
			"inf",
			HttpStatus.INTERNAL_SERVER_ERROR.value()
		);

String sql = """
select month(fecha_emision) as mes,
sum(ganancia) as ganancia,
sum(costo_total) as costo_total from
factura where lower(tipo_pago) = 'e' and
fecha_emision between '2024-01-01' and '2024-12-31'
group by mes
""";

List<ResumenDto> registrosDelInventario = jdbcTemplate.query(
	sql, new BeanPropertyRowMapper<>(ResumenDto.class)
);

resultado.put("datos", registrosDelInventario);

resultado.put("inf", HttpStatus.OK.value() );

return resultado;
}



} // class
