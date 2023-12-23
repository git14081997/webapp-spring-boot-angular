
package com.rodriguez.pruebas.controller.manyToMany;

import com.rodriguez.pruebas.dto.manyToMany.EscritorDto;
import com.rodriguez.pruebas.entity.manyToMany.Escritor;
import com.rodriguez.pruebas.repository.manyToMany.EscritorRepository;
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
 * Esta clase contiene los endpoint para consultar,crear o modificar recursos.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/escritor")
public class EscritorController {

	private static final Logger log = LoggerFactory.getLogger(EscritorController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private EscritorRepository escritorRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Integer save(@RequestBody EscritorDto escritorDto ){
		Escritor escritor = MODEL_MAPPER.map(escritorDto,Escritor.class);
		escritor = escritorRepository.save(escritor);
		return escritor.getId();
	}

	@ResponseBody
	@GetMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{id}"
	) public Escritor findById(@PathVariable Integer id){
		Optional<Escritor> resultado = escritorRepository.findById(id);
		return resultado.orElse(null);
	}

	@ResponseBody
	@DeleteMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{id}"
	) public void delete(@PathVariable Integer id){
		escritorRepository.deleteById(id);
	}

	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Escritor> resultados encontrados.
	 */
	@ResponseBody
	@GetMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{pagina}/{cantidad}"
	) public Page<Escritor> findAll(
			@PathVariable Integer pagina,
			@PathVariable Integer cantidad){

		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return escritorRepository.findAll(pageable);
	}

}
