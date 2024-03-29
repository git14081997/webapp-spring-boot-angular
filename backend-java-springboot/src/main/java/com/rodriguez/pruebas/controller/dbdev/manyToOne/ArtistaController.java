
// ...........................................................................
package com.rodriguez.pruebas.controller.dbdev.manyToOne;

import com.rodriguez.pruebas.dto.dbdev.manyToOne.ArtistaDto;
import com.rodriguez.pruebas.entity.dbdev.manyToOne.Artista;
import com.rodriguez.pruebas.repository.dbdev.manyToOne.ArtistaRepository;
import com.rodriguez.pruebas.service.dbdev.ArtistaService;
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
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

/**
 * Esta clase contiene los endpoint
 * para consultar, crear o modificar recursos.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
//@CrossOrigin( origins = "http://localhost:4200" )
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@RequestMapping("api/artista")
public class ArtistaController {

	private static final Logger LOGGER =
		LoggerFactory.getLogger(ArtistaController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private ArtistaService artistaService;

	@Autowired
	private ArtistaRepository artistaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;



	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody ArtistaDto artistaDto )
	{
		Artista artista =
			MODEL_MAPPER.map(artistaDto,Artista.class);
		artista = artistaRepository.save(artista);
		return artista.getId();
	}



	@GetMapping(
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{id}"
	)
	public Artista findById(@PathVariable Integer id)
	{
		Optional<Artista> resultado =
			artistaRepository.findById(id);
		return resultado.orElse(null);
	}


	/*
	@GetMapping(
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<Artista> findAll()
	{
		return artistaService.findAll();
	}
	*/



	/**
	 * Retorna un listado ordenado por id
	 * de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Artista> resultados encontrados.
	 */
	@GetMapping(
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE,
	value = "{pagina}/{cantidad}"
	) public Page<Artista> findAll(
		@PathVariable Integer pagina,
		@PathVariable Integer cantidad
	)
	{
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return artistaRepository.findAll(pageable);
	}



	@DeleteMapping(
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{id}"
	)
	public void delete(@PathVariable Integer id)
	{
		artistaRepository.deleteById(id);
	}


}
