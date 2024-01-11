
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ClienteAbona;
import com.rodriguez.pruebas.entity.inventarioFacturacion.IngresosEgresos;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.IngresosEgresosRepository;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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
@RequestMapping("api/clienteabona")
public class ClienteAbonaController {

	private static final Logger log = LoggerFactory.getLogger(ClienteAbonaController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ClienteAbonaRepository clienteAbonaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private FacturaRepository facturaRepository;

	@Autowired
	private IngresosEgresosRepository ingresosEgresosRepository;



	 
	@PostMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody ClienteAbona clienteAbona ){
		//ClienteAbona clienteAbona = MODEL_MAPPER.map(clienteAbonaDto, ClienteAbona.class);
		clienteAbona.setDetalles("CLIENTE HACE PAGO");
		clienteAbona = clienteAbonaRepository.save(clienteAbona);


		// REGISTRA ABONO EN USUARIO-1
		BigDecimal valorPago = clienteAbona.getAbonos();

		BigDecimal valorCero = new BigDecimal(0);

		if(valorPago.compareTo( valorCero ) > 0 ){






			// Se reduce saldo pendiente de pago del Cliente-1
			Usuario clienteResponsable = usuarioRepository.getReferenceById( clienteAbona.getCliente().getId() );
			BigDecimal pendienteDePagoEnCliente = clienteResponsable.getPendienteDePago();
			BigDecimal nuevoSaldoPendienteEnCliente = pendienteDePagoEnCliente.subtract( valorPago );
			clienteResponsable.setPendienteDePago( nuevoSaldoPendienteEnCliente );
			// Se reduce saldo pendiente de pago del Cliente-2




			// Se agrega al historico de ingresos y egresos-1
			// estos son ingresos brutos, la ganancia exacta esta por factura
			// si y solo si el pago fue en efectivo o si ya se pago toda la factura/pedido

			IngresosEgresos ingresosEgresos = new IngresosEgresos();
			ingresosEgresos.setIngresos( valorPago );
			ingresosEgresos.setEgresos( valorCero );
			ingresosEgresos.setDetalle("Abono de cliente a su saldo pendiente de pago" );
			// Se agrega al historico de ingresos y egresos-2






		} // REGISTRA ABONO EN USUARIO-2







		return clienteAbona.getId();
	}


	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public ClienteAbona findById(@PathVariable Integer id){
		Optional<ClienteAbona> resultado = clienteAbonaRepository.findById(id);
		return resultado.orElse(null);
	}


	/*
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteAbona> findAll(){
		return clienteAbonaRepository.findAll();
	}
	*/


	/**
	 * Retorna un listado ordenado por fecha descendente de
	 * cargos y abonos de un cliente especifico.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<ClienteAbona> resultados encontrados.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
	public Page<ClienteAbona> findAllByUsuarioId(@PathVariable Integer pagina, @PathVariable Integer cantidad,
		@PathVariable Integer usuarioid) {

		Sort sort = Sort.by(Sort.Direction.DESC ,"fecha");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		Usuario clienteResponsable = usuarioRepository.getReferenceById(usuarioid);

		return clienteAbonaRepository.findByCliente(pageable, clienteResponsable);
	}




/*
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		clienteAbonaRepository.deleteById(id);
	}
 */






/*
	private List<ClienteAbona> getUltimoSaldo(Integer usuarioId ){

	String sql = """
SELECT * FROM INVENTARIO_FACTURACION.CLIENTE_ABONA WHERE
CLIENTE_ABONA.USUARIO_ID = ? ORDER BY CLIENTE_ABONA.FECHA DESC
""";

	List<ClienteAbona> historialCargosAbonos = jdbcTemplate.query(
		sql, new BeanPropertyRowMapper<>(ClienteAbona.class), usuarioId
	);

	return historialCargosAbonos;

	}
	*/



}
