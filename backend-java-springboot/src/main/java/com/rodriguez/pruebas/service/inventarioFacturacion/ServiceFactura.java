
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
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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



@Transactional( rollbackFor = {RuntimeException.class, Exception.class} )
@Override
public Map<String, Object> anularFactura( Integer facturaid ) {


Map<String, Object> resultado = new HashMap<>();

BigDecimal cero = new BigDecimal(0);


if( facturaid == null )
{
resultado.put( ERROR, "facturaid no puede ser null y debe ser un número !");
resultado.put( INF, HttpStatus.INTERNAL_SERVER_ERROR.value() );
return resultado;
}

resultado.put("msg", "Pedido " + facturaid + " anulado." );

Factura pedidoIncorrectoSeraAnulado = facturaRepository.getReferenceById(facturaid);

BigDecimal totalDelPedido = pedidoIncorrectoSeraAnulado.getTotal();



if(
!pedidoIncorrectoSeraAnulado.getTipoPago().equalsIgnoreCase("C") &&
!pedidoIncorrectoSeraAnulado.getTipoPago().equalsIgnoreCase("E")
) {
resultado.put( ERROR, "Solo puedes anular pedidos al credito o en efetivo !");
resultado.put( INF, HttpStatus.INTERNAL_SERVER_ERROR.value() );

return resultado;
}

log.info(pedidoIncorrectoSeraAnulado.getTipoPago());






List<FacturaDetalle> detallesFactura = facturaDetalleRepository.findByFactura(pedidoIncorrectoSeraAnulado);

for( FacturaDetalle detalleN : detallesFactura )
{

// actualizacion de existencias por anulacion de pedido
Producto productoNDelPedido = detalleN.getProducto();
Producto productoDB = productoRepository.getReferenceById(productoNDelPedido.getId());
Integer hayEnDB = productoDB.getExistencias();
Integer newExistenciaActual = hayEnDB + detalleN.getCantidadProductoVendido();
productoDB.setExistencias( newExistenciaActual );
productoRepository.save(productoDB);
// actualizacion de existencias por anulacion de pedido





// actualizacion de entradas del inventario por producto-1
Inventario inventarioProductoN = new Inventario();
inventarioProductoN.setFecha(new Date());

inventarioProductoN.setProducto(productoDB);

Inventario ultimoRegistroDelInventarioDelProducto =
	buscarUltimoRegistroDelInventarioDelProducto( productoDB.getId() );

Integer saldoAnterior = ultimoRegistroDelInventarioDelProducto.getExistencia();

inventarioProductoN.setSaldoAnterior(saldoAnterior);
inventarioProductoN.setEntradas( detalleN.getCantidadProductoVendido() );
inventarioProductoN.setSalidas(0);

inventarioProductoN.setExistencia(
	inventarioProductoN.getSaldoAnterior() +
	inventarioProductoN.getEntradas() -
	inventarioProductoN.getSalidas()
);

inventarioRepository.save(inventarioProductoN);
// actualizacion de entradas del inventario por producto-2


} // analizando detalles del pedido






// marcando pedido como anulado !
pedidoIncorrectoSeraAnulado.setTipoPago("A");
pedidoIncorrectoSeraAnulado.setFechaAnulacion( new Date() );
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

	if( !usuarioOptional.isPresent() ) {
		String msgError = "No existe cliente";
		resultado.put(ERROR, msgError);
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

	clienteAbona.setFecha(new Date());

	clienteAbona.setSaldoAnterior( saldoPendienteDePago );

	clienteAbona.setCargos( cero );

	clienteAbona.setAbonos( totalDelPedido );

	clienteAbona.setSaldo( nuevoSaldo );

	clienteAbona = clienteAbonaRepository.save(clienteAbona);


} // pedido al credito
else
{
	log.error("Tipo de pedido es: '" + pedidoIncorrectoSeraAnulado.getTipoPago() + "'" +
	" Entonces se evaluara si es pedido en Efectivo.");
}






// si fue unPedido pagado en efectivo, se debe agregar un gasto por el monto total.
if( pedidoIncorrectoSeraAnulado.getTipoPago().equalsIgnoreCase("E") )
{
	IngresosEgresos ie = new IngresosEgresos();

	ie.setFecha(new Date());

	ie.setDetalle(
		"Se anula pedido " + pedidoIncorrectoSeraAnulado.getId() + "." +
		"\nContiene uno o más errores." +
		"\nFue pedido con tipoPago: '" + pedidoIncorrectoSeraAnulado.getTipoPago().toString() + "'."
	);

	ie.setEgresos(totalDelPedido);

	ie.setIngresos(cero);

	ie = ingresosEgresosRepository.save(ie);

} // pedido en Efectivo
else
{
	log.error("Pedido no es en efectivo !");
}



resultado.put( INF, HttpStatus.OK.value() );

return resultado;

} // anularFactura








@Transactional( readOnly = true )
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






} // class
