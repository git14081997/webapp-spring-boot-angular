
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.FacturaDetalle;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaDetalleRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ProductoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

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
@RequestMapping("api/facturadetalle")
public class FacturaDetalleController {

	private static final Logger log = LoggerFactory.getLogger(FacturaDetalleController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private FacturaDetalleRepository facturaDetalleRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Transactional
	@PostMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody FacturaDetalle facturaDetalle ){
		//FacturaDetalle facturaDetalle = MODEL_MAPPER.map(facturaDetalleDto, FacturaDetalle.class);
		facturaDetalle = facturaDetalleRepository.save(facturaDetalle);
		return facturaDetalle.getId();
	}


	/**
	 * Retorna un listado del detalle por factura/pedido
	 * de la factura con el id correspondiente.
	 *
	 * @param facturaid consultada.
	 * @return List<FacturaDetalle> resultados encontrados.
	 */
	@Transactional
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{facturaid}")
	public List<FacturaDetalle> find(@PathVariable Integer facturaid) {
		String sql = "SELECT * FROM INVENTARIO_FACTURACION.FACTURA_DETALLE WHERE FACTURA_ID = ? ORDER BY ID ASC";
		List<FacturaDetalle> detallesPorFactura = jdbcTemplate.query(
				sql, new BeanPropertyRowMapper<>(FacturaDetalle.class), facturaid
		);
		return detallesPorFactura;
	}


}
