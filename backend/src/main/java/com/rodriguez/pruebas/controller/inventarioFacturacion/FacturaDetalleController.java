
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.FacturaDetalleDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.FacturaDetalle;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaDetalleRepository;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

/**
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @Author Franklin Rodriguez
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
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Integer save(@RequestBody FacturaDetalleDto facturaDetalleDto ){
		FacturaDetalle facturaDetalle = MODEL_MAPPER.map(facturaDetalleDto, FacturaDetalle.class);
		facturaDetalle = facturaDetalleRepository.save(facturaDetalle);
		return facturaDetalle.getId();
	}


	@ResponseBody
	@GetMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{id}"
	) public FacturaDetalle findById(@PathVariable Integer id){
		Optional<FacturaDetalle> resultado = facturaDetalleRepository.findById(id);
		return resultado.orElse(null);
	}

/*
@ResponseBody
@GetMapping(
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE
) public List<Artista> findAll(){
return artistaService.findAll();
}
*/

/**
 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
 *
 * @param pagina consultada.
 * @param cantidad maxima por pagina.
 * @return Page<FacturaDetalle> resultados encontrados.
 */
@ResponseBody
@GetMapping(
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE,
value = "{pagina}/{cantidad}"
) public Page<FacturaDetalle> findAll(
	@PathVariable Integer pagina,
	@PathVariable Integer cantidad){

	Sort sort = Sort.by(Sort.Direction.ASC,"id");
	Pageable pageable = PageRequest.of(pagina,cantidad,sort);
	return facturaDetalleRepository.findAll(pageable);
}


@ResponseBody
@DeleteMapping(
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE,
	value = "{id}"
) public void delete(@PathVariable Integer id){
	facturaDetalleRepository.deleteById(id);
}

}
