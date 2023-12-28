
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.TipoPagoDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.TipoPago;
import com.rodriguez.pruebas.repository.inventarioFacturacion.TipoPagoRepository;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("api/tipopago")
public class TipoPagoController {

	private static final Logger log = LoggerFactory.getLogger(TipoPagoController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private TipoPagoRepository tipoPagoRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody TipoPagoDto tipoPagoDto ){
		TipoPago tipoPago = MODEL_MAPPER.map(tipoPagoDto, TipoPago.class);
		tipoPago = tipoPagoRepository.save(tipoPago);
		return tipoPago.getId();
	}


	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public TipoPago findById(@PathVariable Integer id){
		Optional<TipoPago> resultado = tipoPagoRepository.findById(id);
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
 * @return Page<TipoPago> resultados encontrados.
 */
@ResponseBody
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
public Page<TipoPago> findAll(
	@PathVariable Integer pagina,
	@PathVariable Integer cantidad){

	Sort sort = Sort.by(Sort.Direction.ASC,"id");
	Pageable pageable = PageRequest.of(pagina,cantidad,sort);
	return tipoPagoRepository.findAll(pageable);
}


@ResponseBody
@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
public void delete(@PathVariable Integer id){
	tipoPagoRepository.deleteById(id);
}


	@ResponseBody
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer update(@RequestBody TipoPagoDto tipoPagoDto ){

		Integer tipoPagoId = tipoPagoDto.getId();

		if(tipoPagoId == null){
			return -1;
		}
		else {

			Optional<TipoPago> tipoPagoEnDB = tipoPagoRepository.findById(tipoPagoId);

			if( tipoPagoEnDB.isPresent() ){
				TipoPago tipoPagoReal = tipoPagoEnDB.get();

				tipoPagoReal.setDescripcion(tipoPagoDto.getDescripcion());

				tipoPagoRepository.save(tipoPagoReal);
				return 0;
			}
			else {
				return -2;
			}
		}
	}


	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<TipoPago> resultados encontrados.
	 */
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/buscar")
	public Page<TipoPago> findAllByDescripcion(
			@PathVariable Integer pagina, @PathVariable Integer cantidad,
			@RequestParam(required = true) String descripcion){

		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		return tipoPagoRepository.findByDescripcionContainingIgnoreCase(pageable, descripcion);
	}

}
