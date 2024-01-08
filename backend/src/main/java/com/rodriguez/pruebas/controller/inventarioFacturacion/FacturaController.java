
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ClienteAbona;
import com.rodriguez.pruebas.entity.inventarioFacturacion.DetallePedidoDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Factura;
import com.rodriguez.pruebas.entity.inventarioFacturacion.FacturaDetalle;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Inventario;
import com.rodriguez.pruebas.entity.inventarioFacturacion.PedidoDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaDetalleRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.InventarioRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ProductoRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.UsuarioRepository;
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
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


/**
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
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





	@Transactional
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody PedidoDto pedidoDto ){

		/* Factura factura = MODEL_MAPPER.map(facturaDto, Factura.class); */

		Factura factura = new Factura();


		factura.setGanancia( pedidoDto.getGanancia() );

		factura.setIva( pedidoDto.getIva() );

		factura.setTotal( pedidoDto.getTotal() );

		ClienteAbona cargosAbonosCliente = new ClienteAbona();

		Usuario cliente = usuarioRepository.getReferenceById(pedidoDto.getUsuarioId());

		cargosAbonosCliente.setCliente(cliente);

		cargosAbonosCliente.setCargos(pedidoDto.getTotal());
		cargosAbonosCliente.setAbonos(new BigDecimal(0));
		cargosAbonosCliente.setDetalles("CLIENTE NOS COMPRA");

		// traer ultimo registro de cargos y abonos para consultar el saldo de ese ultimo registro
		Sort sort = Sort.by(Sort.Direction.DESC ,"fecha");
		Pageable pageableCargosAbonosCliente = PageRequest.of(0,3,sort);

		Optional<Usuario> optionalUsuario = usuarioRepository.findById(pedidoDto.getUsuarioId());

		if(optionalUsuario.isEmpty()){
			throw new RuntimeException("Usuario con ID no existe para guardar factura.");
		}

		Usuario clienteCompro = optionalUsuario.get();
		Page<ClienteAbona> cargos_abonos_del_cliente = clienteAbonaRepository.findByCliente(
			pageableCargosAbonosCliente, clienteCompro
		);

		List<ClienteAbona> listaDeCargosAbonosCliente = cargos_abonos_del_cliente.getContent();
		ClienteAbona ultimoRegistroCargosAbonos = listaDeCargosAbonosCliente.get(0);

		cargosAbonosCliente.setSaldoAnterior(ultimoRegistroCargosAbonos.getSaldo());

		BigDecimal saldoAnterior = ultimoRegistroCargosAbonos.getSaldo();

		BigDecimal nuevoSaldoActual = saldoAnterior.add( cargosAbonosCliente.getCargos() );

		cargosAbonosCliente.setSaldo(nuevoSaldoActual);



		BigDecimal total = pedidoDto.getTotal();
		BigDecimal iva = pedidoDto.getIva();
		BigDecimal subtotal = total.subtract(iva);
		factura.setSubtotalSinIva(subtotal);

		factura.setTipoPago(pedidoDto.getTipoPago() ); // Efectivo, Credito

		if(pedidoDto.getTipoPago().equals("C") || pedidoDto.getTipoPago().equals("V")){
			// Venta al credito
			// Visto pendiente de confirmar pedido
			factura.setPendienteDePago(pedidoDto.getTotal());
		}

		if(pedidoDto.getTipoPago().equals("E")){
			// Venta en efectivo
			factura.setPendienteDePago(new BigDecimal(0));
		}

		Usuario usuarioCliente = optionalUsuario.get();

		factura.setCliente(usuarioCliente);

		factura.setNombreCompleto(usuarioCliente.getNombreCompleto());

		BigDecimal saldoPendiente = usuarioCliente.getPendienteDePago();

		// Saldo anterior antes de este pedidoN
		//usuarioCliente.setPendienteDePagoCopy(saldoPendiente);

		usuarioCliente.setPendienteDePago(
			saldoPendiente.add( pedidoDto.getTotal() )
		);

		factura = facturaRepository.save(factura);

		Integer idFactura = factura.getId();


		cargosAbonosCliente.setFactura(factura);
		clienteAbonaRepository.save(cargosAbonosCliente);


		// DETALLES DE FACTURA/PEDIDO
		List<DetallePedidoDto> detallesDelPedido = pedidoDto.getDetalle();

		for(DetallePedidoDto detallePedidoDto: detallesDelPedido){

			FacturaDetalle facturaDetalle = new FacturaDetalle();

			facturaDetalle.setFactura(factura);

			Optional<Producto> optionalProducto =
			productoRepository.findById(detallePedidoDto.getProductoId());

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


				// reduccion del inventario
				Inventario inventario = new Inventario();
				inventario.setEntradas(0);
				inventario.setSalidas(detallePedidoDto.getCantidadProductoVendido());

				// traer el ultimo registro por fecha y guardar su saldo como saldoAnterior
				Integer saldoAnteriorProducto = 0;
				Inventario ultimoRegistroDelInventario =
				buscarUltimoRegistroDelInventarioDelProducto(productoN.getId());
				saldoAnteriorProducto = ultimoRegistroDelInventario.getExistencia();

				inventario.setSaldoAnterior(saldoAnteriorProducto);

				inventario.setProducto(productoN);

				Integer saldoActualExistencias = saldoAnteriorProducto + inventario.getEntradas() - inventario.getSalidas();

				inventario.setExistencia( saldoActualExistencias );

				inventarioRepository.save(inventario);


				// Actualizacion del saldo de exitencias del producto
				productoN.setExistencias(saldoActualExistencias);
				productoRepository.save(productoN);


			} // actualizar existencias del producto


		}



		return idFactura;
	}




	@Transactional
	private Inventario buscarUltimoRegistroDelInventarioDelProducto(Integer productoId){
		String sql = "SELECT * FROM INVENTARIO_FACTURACION.INVENTARIO WHERE PRODUCTO_ID = ? ORDER BY FECHA DESC";
		List<Inventario> registrosDelInventario = jdbcTemplate.query(
				sql, new BeanPropertyRowMapper<>(Inventario.class), productoId
		);

		for( Inventario registroNDelInventarioProductoX : registrosDelInventario ){
			log.info( registroNDelInventarioProductoX.toString() );
		}

		return registrosDelInventario.get(0);
	}







	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public Factura findById(@PathVariable Integer id){
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
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
	public Page<Factura> findAll(@PathVariable Integer pagina, @PathVariable Integer cantidad){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
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
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/{usuarioId}")
	public Page<Factura> findByCliente(
	@PathVariable Integer pagina, @PathVariable Integer cantidad, @PathVariable Integer usuarioId){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return facturaRepository.findByCliente(pageable,usuarioId);
	}





	/**
	 * Retorna las facturas que le pertenescan a cierto cliente y
	 * estarán ordenadadas por fecha de emision de manera descendente
	 * para ver las facturas más recientes.
	 *
	 * @return List<Factura> resultados encontrados.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "nombre/{nombreusuario}")
	public List<Factura> findByCliente(@PathVariable String nombreusuario){

String sql = """
SELECT FACTURA.* FROM INVENTARIO_FACTURACION.FACTURA left join INVENTARIO_FACTURACION.USUARIO
on FACTURA.USUARIO_ID = USUARIO.ID
WHERE FACTURA.NOMBRE_COMPLETO LIKE ? OR USUARIO.NOMBRE_COMPLETO LIKE ?
ORDER BY FACTURA.FECHA_EMISION DESC
""";

		String patronDeBusqueda = "%" + nombreusuario + "%";

		List<Factura> facturasDelCliente = jdbcTemplate.query(
			sql, new BeanPropertyRowMapper<>(Factura.class),
			nombreusuario, patronDeBusqueda
		);
		return facturasDelCliente;
	}



}
