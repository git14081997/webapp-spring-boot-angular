
package com.rodriguez.pruebas.controller.dbdev.oneToMany;

import com.rodriguez.pruebas.dto.dbdev.oneToMany.AArtistaDto;
import com.rodriguez.pruebas.entity.dbdev.oneToMany.AArtista;
import com.rodriguez.pruebas.repository.dbdev.oneToMany.AArtistaRepository;
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
 * Esta clase contiene los endpoint para consultar,crear o modificar recursos.
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
@RequestMapping("api/aartista")
public class AArtistaController {

	private static final Logger log = LoggerFactory.getLogger(AArtistaController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private AArtistaRepository aArtistaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@PostMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody AArtistaDto aArtistaDto )
	{
		AArtista aArtista = MODEL_MAPPER.map(aArtistaDto,AArtista.class);
		aArtista = aArtistaRepository.save(aArtista);
		return aArtista.getId();
	}




	@GetMapping( consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public AArtista findById(@PathVariable Integer id)
	{
		Optional<AArtista> resultado = aArtistaRepository.findById(id);
		return resultado.orElse(null);
	}




	@DeleteMapping( consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public void delete(@PathVariable Integer id)
	{
		aArtistaRepository.deleteById(id);
	}



	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<AArtista> resultados encontrados.
	 */
	@GetMapping( consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}" )
	public Page<AArtista> findAll( @PathVariable Integer pagina, @PathVariable Integer cantidad )
	{
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return aArtistaRepository.findAll(pageable);
	}


}
