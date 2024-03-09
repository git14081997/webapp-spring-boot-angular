
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ClienteAbona;
import com.rodriguez.pruebas.dto.inventarioFacturacion.DetallePedidoDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Factura;
import com.rodriguez.pruebas.entity.inventarioFacturacion.FacturaDetalle;
import com.rodriguez.pruebas.entity.inventarioFacturacion.IngresosEgresos;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Inventario;
import com.rodriguez.pruebas.dto.inventarioFacturacion.PedidoDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaDetalleRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.IngresosEgresosRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.InventarioRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ProductoRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.UsuarioRepository;
import com.rodriguez.pruebas.service.inventarioFacturacion.IServiceFactura;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;


/**
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
//@CrossOrigin( origins = "http://localhost:4200" )
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("api/factura")
public class FacturaController {

	private static final Logger log = LoggerFactory.getLogger(FacturaController.class);

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

	@Autowired
	private IServiceFactura serviceFactura;


	@Transactional
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "dev/{facturaid}" )
	public void registrarDevolucion( @PathVariable Integer facturaid )
	{

		// se registra la devolucion de mercaderia al inventario

		Factura pedidoAnuladoPorDevolucion = facturaRepository.getReferenceById(facturaid);

if(pedidoAnuladoPorDevolucion.getTipoPago().equals("V")){


List<FacturaDetalle> detallesFactura = facturaDetalleRepository.findByFactura(pedidoAnuladoPorDevolucion);

for( FacturaDetalle detalleN : detallesFactura ){

// actualizacion de existencias por devolucion de mercaderia-1
Producto productoNDelPedido = detalleN.getProducto();
Producto productoDB = productoRepository.getReferenceById(productoNDelPedido.getId());
Integer hayEnDB = productoDB.getExistencias();
Integer newExistenciaActual = hayEnDB + detalleN.getCantidadProductoVendido();
productoDB.setExistencias( newExistenciaActual );
productoRepository.save(productoDB);
// actualizacion de existencias por devolucion de mercaderia-2




// actualizacion de entradas del inventario por producto-1
Inventario inventarioProductoN = new Inventario();
inventarioProductoN.setFecha(new Date());

inventarioProductoN.setProducto(productoDB);

Inventario ultimoRegistroDelInventarioDelProducto = serviceFactura.buscarUltimoRegistroDelInventarioDelProducto( productoDB.getId() );
Integer saldoAnterior = ultimoRegistroDelInventarioDelProducto.getExistencia();

inventarioProductoN.setSaldoAnterior(saldoAnterior);
inventarioProductoN.setEntradas( detalleN.getCantidadProductoVendido() );
inventarioProductoN.setSalidas(0);

inventarioProductoN.setExistencia(
	inventarioProductoN.getSaldoAnterior() + inventarioProductoN.getEntradas() - inventarioProductoN.getSalidas()
);

inventarioRepository.save(inventarioProductoN);
// actualizacion de entradas del inventario por producto-2


} // analizando detalles del pedido

BigDecimal cero = new BigDecimal(0);

pedidoAnuladoPorDevolucion.setTipoPago("D");

pedidoAnuladoPorDevolucion.setGanancia(cero);
pedidoAnuladoPorDevolucion.setIva(cero);
pedidoAnuladoPorDevolucion.setTotal(cero);
pedidoAnuladoPorDevolucion.setSubtotalSinIva(cero);

pedidoAnuladoPorDevolucion.setFechaDevolucion(new Date());

facturaRepository.save(pedidoAnuladoPorDevolucion);
} // solo si es pedido/factura en Visto


}





	@Transactional
	//@Transactional(rollbackFor = { SQLException.class })
	@PostMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public Integer save(@RequestBody PedidoDto pedidoDto )
	{

		/* Factura factura = MODEL_MAPPER.map(facturaDto, Factura.class); */

		Factura factura = new Factura(); // Factura o Pedido
		factura.setFechaEmision(new Date());

		BigDecimal cero = new BigDecimal(0);

		Usuario cliente = usuarioRepository.getReferenceById(pedidoDto.getUsuarioId());

		BigDecimal totalFactura = pedidoDto.getTotal();
		BigDecimal ivaFactura = pedidoDto.getIva();
		BigDecimal costoFactura = pedidoDto.getCostoTotal();

		BigDecimal totalMenosIva = totalFactura.subtract(ivaFactura);
		BigDecimal ganancia = totalMenosIva.subtract(costoFactura);

		factura.setCostoTotal(pedidoDto.getCostoTotal());
		factura.setGanancia( ganancia );
		factura.setSubtotalSinIva(totalMenosIva);
		factura.setIva( pedidoDto.getIva() );
		factura.setTotal( pedidoDto.getTotal() );
		factura.setTipoPago(pedidoDto.getTipoPago() ); // Efectivo, Credito, Visto

		factura.setCliente(cliente);
		factura.setNombreCompleto(cliente.getNombreCompleto());

		BigDecimal saldoPendiente = cliente.getPendienteDePago();
		BigDecimal nuevoSaldoPendiente = saldoPendiente.add( pedidoDto.getTotal() );

		factura = facturaRepository.save(factura);
		Integer idFactura = factura.getId();







		if( pedidoDto.getTipoPago().equals("V") ){
			// si se reduce del inventario
			// se conserva una factura con tipo de pago V de Visto/Consignacion
			// no genera cargos al cliente, ni ingresos o egresos de efectivo
			// posteriormente se podrá registrar la devolucion del inventario
			// posteriormente se podrá confirmar pedido y hacer los registros correspondientes
		}






		if(
			pedidoDto.getTipoPago().equals("E") ||
			pedidoDto.getTipoPago().equals("C")
		){

			// SE AGREGA UN CARGO AL CLIENTE POR EL MONTO TOTAL
			ClienteAbona cargosAbonosCliente = new ClienteAbona();
			cargosAbonosCliente.setCliente(cliente);
			cargosAbonosCliente.setCargos(pedidoDto.getTotal());

			BigDecimal saldoAnterior = getUltimoRegistroSaldoActual( pedidoDto.getUsuarioId() );
			BigDecimal nuevoSaldoActual = saldoAnterior.add( pedidoDto.getTotal() );

			cargosAbonosCliente.setSaldoAnterior(saldoAnterior);
			cargosAbonosCliente.setSaldo(nuevoSaldoActual);
			cargosAbonosCliente.setDetalles("PEDIDO # " + idFactura );
			cargosAbonosCliente.setFactura(factura);
			// SE AGREGA UN CARGO AL CLIENTE POR EL MONTO TOTAL


			if(pedidoDto.getTipoPago().equals("E")){
				cargosAbonosCliente.setAbonos(pedidoDto.getTotal());
				cargosAbonosCliente.setSaldo(saldoAnterior);

				IngresosEgresos ingresosEgresos = new IngresosEgresos();
				ingresosEgresos.setDetalle("Pago en efectivo por pedido # " + idFactura );
				ingresosEgresos.setIngresos( pedidoDto.getTotal() );
				ingresosEgresos.setEgresos(cero);
				ingresosEgresos.setFecha(new Date());
				ingresosEgresosRepository.save(ingresosEgresos);

			}


			if(pedidoDto.getTipoPago().equals("C")){
				cargosAbonosCliente.setAbonos(cero);
				cliente.setPendienteDePago(nuevoSaldoPendiente);
				usuarioRepository.save(cliente);
			}


			clienteAbonaRepository.save(cargosAbonosCliente);
		}














		// DETALLES DE FACTURA/PEDIDO-1
		List<DetallePedidoDto> detallesDelPedido = pedidoDto.getDetalle();

		FacturaDetalle facturaDetalle;
		for(DetallePedidoDto detallePedidoDto: detallesDelPedido){

			facturaDetalle = new FacturaDetalle();

			facturaDetalle.setFactura(factura);

			Optional<Producto> optionalProducto = productoRepository.findById(detallePedidoDto.getProductoId());

			if(optionalProducto.isPresent()){

				Producto productoN = optionalProducto.get();

				facturaDetalle.setProducto(productoN);
				facturaDetalle.setCantidadProductoVendido(detallePedidoDto.getCantidadProductoVendido());
				facturaDetalle.setPrecioVentaPorProducto(detallePedidoDto.getPrecioVentaPorProducto());


				facturaDetalle.setNombreProducto( productoN.getNombre() );
				facturaDetalle.setGananciaUnidad( productoN.getGanancia() );
				facturaDetalle.setCostoUnidad( productoN.getCostoUnidad() );

				facturaDetalle.setSubtotalPorProducto( detallePedidoDto.getSubtotalPorProducto() );
				facturaDetalle.setIvaDelSubtotalPorProducto( detallePedidoDto.getIvaDelSubtotalPorProducto() );
				facturaDetalle.setCostoDelSubtotalPorProducto( detallePedidoDto.getCostoDelSubtotalPorProducto() );
				facturaDetalle.setGananciaDelSubtotalPorProducto( detallePedidoDto.getGananciaDelSubtotalPorProducto() );

				facturaDetalleRepository.save(facturaDetalle);


				// reduccion del inventario-1
				Inventario inventario = new Inventario();
				inventario.setEntradas(0);
				inventario.setSalidas(detallePedidoDto.getCantidadProductoVendido());

				// traer el ultimo registro por fecha y guardar su saldo como saldoAnterior
				Integer saldoAnteriorProducto = 0;
				Inventario ultimoRegistroDelInventario =
					serviceFactura.buscarUltimoRegistroDelInventarioDelProducto(productoN.getId());
				saldoAnteriorProducto = ultimoRegistroDelInventario.getExistencia();

				inventario.setSaldoAnterior(saldoAnteriorProducto);

				inventario.setProducto(productoN);

				Integer saldoActualExistencias = saldoAnteriorProducto + inventario.getEntradas() - inventario.getSalidas();

				inventario.setExistencia( saldoActualExistencias );

				inventarioRepository.save(inventario);


				// Actualizacion del saldo de exitencias del producto
				productoN.setExistencias(saldoActualExistencias);
				productoRepository.save(productoN);
				// reduccion del inventario-2


			} // actualizar existencias del producto


		}

		// DETALLES DE FACTURA/PEDIDO-2




		return idFactura;
	}















	 
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}" )
	public Factura findById(@PathVariable Integer id)
	{
		Optional<Factura> resultado = facturaRepository.findById(id);
		return resultado.orElse(null);
	}



	/*
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Factura> findAll(){
		return facturaRepository.findAll();
	}
	*/



	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Factura> resultados encontrados.
	 */
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}" )
	public Page<Factura> findAll( @PathVariable Integer pagina, @PathVariable Integer cantidad )
	{
		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return facturaRepository.findAll(pageable);
	}





/*
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		facturaRepository.deleteById(id);
	}
*/




	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Factura> resultados encontrados.
	 */
	 
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/{usuarioId}" )
	public Page<Factura> findByCliente(
		@PathVariable Integer pagina, @PathVariable Integer cantidad,
		@PathVariable Integer usuarioId )
	{
		Sort sort = Sort.by( Sort.Direction.DESC,"id" );
		Pageable pageable = PageRequest.of( pagina, cantidad, sort );
		return facturaRepository.findByCliente( pageable, usuarioId );
	}






	/**
	 * Retorna las facturas que le pertenescan a cierto cliente y
	 * estarán ordenadadas por fecha de emision de manera descendente
	 * para ver las facturas más recientes.
	 *
	 * @return List<Factura> resultados encontrados.
	 */
	@GetMapping(
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "nombre/{nombreusuario}"
	)
	public List<Factura> findByCliente(
		@PathVariable String nombreusuario
	)
	{

		nombreusuario = nombreusuario.toLowerCase();

String sqlFacturasEnVisto = """
SELECT factura.* FROM factura WHERE
 lower(factura.tipo_pago) = 'v'
ORDER BY factura.fecha_emision DESC
""";

if( nombreusuario.equalsIgnoreCase("vvisto") )
{
	List<Factura> facturasDelCliente = jdbcTemplate.query(
		sqlFacturasEnVisto,
		new BeanPropertyRowMapper<>(Factura.class)
	);
	return facturasDelCliente;
}



String sql = """
SELECT factura.* FROM factura left join usuario
on factura.usuario_id = usuario.id
WHERE
 factura.id = ? OR
 usuario.id = ? OR
 lower(factura.nombre_completo) LIKE ? OR
 lower(usuario.nombre_completo) LIKE ?
ORDER BY factura.fecha_emision DESC
""";



		String patronDeBusqueda = "%" + nombreusuario + "%";

		List<Factura> facturasDelCliente = jdbcTemplate.query(
			sql, new BeanPropertyRowMapper<>(Factura.class),
			nombreusuario,
			nombreusuario,
			patronDeBusqueda,
			patronDeBusqueda
		);
		return facturasDelCliente;
	}






	@Transactional
	private BigDecimal getUltimoRegistroSaldoActual( Integer usuarioId )
	{

		Sort sort = Sort.by(
			Sort.Direction.DESC ,
		"fecha"
		);
		Pageable pageableCargosAbonosCliente =
			PageRequest.of(0,1,sort);

		Optional<Usuario> optionalUsuario =
			usuarioRepository.findById(usuarioId);

		if(optionalUsuario.isEmpty())
		{
			throw new RuntimeException(
			"Usuario con ID no existe para guardar factura."
			);
		}

		Usuario clienteCompro = optionalUsuario.get();
		Page<ClienteAbona> cargos_abonos_del_cliente =
			clienteAbonaRepository.findByCliente(
				pageableCargosAbonosCliente,
				clienteCompro
			);

		List<ClienteAbona> listaDeCargosAbonosCliente =
			cargos_abonos_del_cliente.getContent();

		ClienteAbona ultimoRegistroCargosAbonos =
			listaDeCargosAbonosCliente.get(0);

		return ultimoRegistroCargosAbonos.getSaldo();
	}










	@Transactional
	@PostMapping(
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "yes/{facturaid}"
	)
	public void confirmacionPedidoEnVisto(
		@PathVariable Integer facturaid) {

		BigDecimal cero = new BigDecimal(0);

		Factura facturaConfirmada =
			facturaRepository.getReferenceById(facturaid);

		if( facturaConfirmada.getTipoPago().equals("V") ){


		List<FacturaDetalle> detallesFacturaConfirmada =
			facturaDetalleRepository.findByFactura(
			facturaConfirmada
		);

		Usuario cliente =
			usuarioRepository.getReferenceById(
				facturaConfirmada.getCliente().getId()
			);

		BigDecimal saldoPendiente = cliente.getPendienteDePago();
		BigDecimal nuevoSaldoPendiente =
			saldoPendiente.add( facturaConfirmada.getTotal() );
		cliente.setPendienteDePago( nuevoSaldoPendiente );
		usuarioRepository.save(cliente);

		facturaConfirmada.setTipoPago("C");
		facturaConfirmada.setFechaEmision(new Date());
		facturaRepository.save(facturaConfirmada);


		// SE AGREGA UN CARGO AL CLIENTE POR EL MONTO TOTAL
		ClienteAbona cargosAbonosCliente = new ClienteAbona();
		cargosAbonosCliente.setCliente(cliente);
		cargosAbonosCliente.setCargos(facturaConfirmada.getTotal());

		BigDecimal saldoAnterior =
			getUltimoRegistroSaldoActual(
				facturaConfirmada.getCliente().getId()
			);

		BigDecimal nuevoSaldoActual =
			saldoAnterior.add( facturaConfirmada.getTotal()
		);

		cargosAbonosCliente.setSaldoAnterior(saldoAnterior);
		cargosAbonosCliente.setSaldo(nuevoSaldoActual);

		cargosAbonosCliente.setDetalles(
			"PEDIDO # " + facturaConfirmada.getId()
		);

		cargosAbonosCliente.setFactura(facturaConfirmada);
		cargosAbonosCliente.setAbonos(cero);
		clienteAbonaRepository.save(cargosAbonosCliente);

		// SE AGREGA UN CARGO AL CLIENTE POR EL MONTO TOTAL
		}


	}

















@Transactional(
	rollbackFor = {
		RuntimeException.class,
		Exception.class,
		IllegalArgumentException.class,
		NoSuchElementException.class
	}
)
@PostMapping(
	produces = MediaType.APPLICATION_JSON_VALUE,
	value = "del/{facturaid}"
)
public ResponseEntity<Map<String, Object>> anularPedido(
	@PathVariable Integer facturaid
)
{

	Map<String, Object> resultado =
		serviceFactura.anularFactura(facturaid);

	int httpStatus = (int) resultado.get("inf");

	return new ResponseEntity<>(
		resultado,
		HttpStatusCode.valueOf( httpStatus )
	);

} // anularPedido









	@GetMapping(
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "resumen"
	)
	public ResponseEntity<Map<String, Object>> resumenDelMes(){

		Map<String, Object> resultado =	serviceFactura.resumen();

		int httpStatus = (int) resultado.get("inf");

		return new ResponseEntity<>(
			resultado,
			HttpStatusCode.valueOf( httpStatus )
		);

	} // anularPedido




} // class
