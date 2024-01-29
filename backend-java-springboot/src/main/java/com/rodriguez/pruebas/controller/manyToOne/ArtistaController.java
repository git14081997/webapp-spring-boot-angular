
package com.rodriguez.pruebas.controller.manyToOne;

import com.rodriguez.pruebas.dto.manyToOne.ArtistaDto;
import com.rodriguez.pruebas.entity.manyToOne.Artista;
import com.rodriguez.pruebas.repository.manyToOne.ArtistaRepository;
import com.rodriguez.pruebas.service.ArtistaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
//@NoArgsConstructor
@RequiredArgsConstructor
@RequestMapping("api/artista")
public class ArtistaController {

	private static final Logger log = LoggerFactory.getLogger(ArtistaController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private ArtistaService artistaService;

	@Autowired
	private ArtistaRepository artistaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Integer save(@RequestBody ArtistaDto artistaDto ){
		Artista artista = MODEL_MAPPER.map(artistaDto,Artista.class);
		artista = artistaRepository.save(artista);
		return artista.getId();
	}


	@ResponseBody
	@GetMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{id}"
	) public Artista findById(@PathVariable Integer id){
		Optional<Artista> resultado = artistaRepository.findById(id);
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
 * @return Page<Artista> resultados encontrados.
 */
@ResponseBody
@GetMapping(
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE,
value = "{pagina}/{cantidad}"
) public Page<Artista> findAll(
	@PathVariable Integer pagina,
	@PathVariable Integer cantidad){

	Sort sort = Sort.by(Sort.Direction.ASC,"id");
	Pageable pageable = PageRequest.of(pagina,cantidad,sort);
	return artistaRepository.findAll(pageable);
}


@ResponseBody
@DeleteMapping(
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE,
	value = "{id}"
) public void delete(@PathVariable Integer id){
	artistaRepository.deleteById(id);
}


}
