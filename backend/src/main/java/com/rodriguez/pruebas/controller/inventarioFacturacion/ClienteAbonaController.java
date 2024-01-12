
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ClienteAbona;
import com.rodriguez.pruebas.entity.inventarioFacturacion.IngresosEgresos;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Date;


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
	private IngresosEgresosRepository ingresosEgresosRepository;




	@Transactional
	@PostMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer clienteAbona(@RequestBody ClienteAbona clienteAbona ){

		//ClienteAbona clienteAbona = MODEL_MAPPER.map(clienteAbonaDto, ClienteAbona.class);

		BigDecimal valorCero = new BigDecimal(0);
		clienteAbona.setId(null);
		BigDecimal valorPago = clienteAbona.getAbonos();


		// Se reduce saldo pendiente de pago del Cliente-1
		Usuario clienteResponsable = usuarioRepository.getReferenceById( clienteAbona.getCliente().getId() );
		BigDecimal pendienteDePagoEnCliente = clienteResponsable.getPendienteDePago();
		BigDecimal nuevoSaldoPendienteEnCliente = pendienteDePagoEnCliente.subtract( valorPago );
		clienteResponsable.setPendienteDePago( nuevoSaldoPendienteEnCliente );
		usuarioRepository.save(clienteResponsable);
		// Se reduce saldo pendiente de pago del Cliente-2


		String detalleDelAbono = "Abono de " + valorPago
		+ " de " + clienteResponsable.getNombreCompleto()
		+ " ; Saldo anterior era: " + pendienteDePagoEnCliente
		+ " ; Nuevo saldo pendiente de pago: " + nuevoSaldoPendienteEnCliente;


		// SE REGISTRA ABONO DEL CLIENTE-1
		clienteAbona.setFecha(new Date());
		clienteAbona.setDetalles( detalleDelAbono );
		clienteAbona.setSaldoAnterior( pendienteDePagoEnCliente );
		clienteAbona.setSaldo( nuevoSaldoPendienteEnCliente );
		clienteAbona = clienteAbonaRepository.save(clienteAbona);
		// SE REGISTRA ABONO DEL CLIENTE-1


		// Se agrega al historico de ingresos y egresos-1
		IngresosEgresos ingresosEgresos = new IngresosEgresos();
		ingresosEgresos.setIngresos( valorPago );
		ingresosEgresos.setEgresos( valorCero );
		ingresosEgresos.setDetalle( detalleDelAbono );
		ingresosEgresosRepository.save(ingresosEgresos);
		// Se agrega al historico de ingresos y egresos-2

		return clienteAbona.getId();
	}



	 







	/**
	 * Retorna un listado ordenado por fecha descendente de
	 * cargos y abonos de un cliente especifico.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<ClienteAbona> resultados encontrados.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/{usuarioid}")
	public Page<ClienteAbona> findAllByUsuarioId(
			@PathVariable Integer pagina,
			@PathVariable Integer cantidad,
			@PathVariable Integer usuarioid) {

		Sort sort = Sort.by(Sort.Direction.DESC ,"fecha");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		Usuario clienteResponsable = usuarioRepository.getReferenceById(usuarioid);

		return clienteAbonaRepository.findByCliente(pageable, clienteResponsable);
	}


}
