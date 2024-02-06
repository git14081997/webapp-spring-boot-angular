
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.IngresosEgresos;
import com.rodriguez.pruebas.repository.inventarioFacturacion.IngresosEgresosRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


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
@RequestMapping("api/ie")
public class IngresosEgresosController {

	private static final Logger log = LoggerFactory.getLogger(IngresosEgresosController.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private IngresosEgresosRepository ingresosEgresosRepository;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void addGasto(@RequestBody IngresosEgresos dto ){

		BigDecimal cero = new BigDecimal(0);

		IngresosEgresos registroIE = new IngresosEgresos();
		registroIE.setEgresos( dto.getEgresos() );
		registroIE.setIngresos( cero );
		registroIE.setDetalle( dto.getDetalle() );
		registroIE.setFecha(new Date());

		ingresosEgresosRepository.save(registroIE);
	}




	/**
	 * Retorna una lista de los ingresos y egresos por año y mes.
	 * @param month month para delimitar registros.
	 * @param year year para delimitar registros.
	 *
	 * @return List<IngresosEgresos> registros encontrados con los parametros proporcionados.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{year}/{month}")
	public List<IngresosEgresos> findAll(@PathVariable Integer year, @PathVariable Integer month){

		String sql = """
			SELECT INGRESOS_EGRESOS.* FROM INVENTARIO_FACTURACION.INGRESOS_EGRESOS
			WHERE YEAR(FECHA) = ? AND MONTH(FECHA) = ? ORDER BY ID DESC
		""";

		return jdbcTemplate.query(
			sql, new BeanPropertyRowMapper<>(IngresosEgresos.class), year, month
		);
	}



}
