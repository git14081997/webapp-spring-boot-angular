
package com.rodriguez.pruebas.controller.dbdev.manyToMany;

import com.rodriguez.pruebas.dto.dbdev.manyToMany.LibroDto;
import com.rodriguez.pruebas.entity.dbdev.manyToMany.Libro;
import com.rodriguez.pruebas.repository.dbdev.manyToMany.LibroRepository;
import lombok.AllArgsConstructor;
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
//@NoArgsConstructor
//@RequiredArgsConstructor
@RequestMapping("/api/libro")
public class LibroController {

	private static final Logger log = LoggerFactory.getLogger(LibroController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private LibroRepository libroRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Integer save(@RequestBody LibroDto libroDto ){
		Libro libro = MODEL_MAPPER.map(libroDto,Libro.class);
		libro = libroRepository.save(libro);
		return libro.getId();
	}

	@ResponseBody
	@GetMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{id}"
	) public Libro findById(@PathVariable Integer id){
		Optional<Libro> resultado = libroRepository.findById(id);
		return resultado.orElse(null);
	}

	@ResponseBody
	@DeleteMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{id}"
	) public void delete(@PathVariable Integer id){
		libroRepository.deleteById(id);
	}

	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Libro> resultados encontrados.
	 */
	@ResponseBody
	@GetMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{pagina}/{cantidad}"
	) public Page<Libro> findAll(
			@PathVariable Integer pagina,
			@PathVariable Integer cantidad){

		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return libroRepository.findAll(pageable);
	}


}
