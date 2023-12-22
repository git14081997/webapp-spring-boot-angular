
package com.rodriguez.pruebas.controller;

import com.rodriguez.pruebas.dto.UsuarioDto;
import com.rodriguez.pruebas.entity.Usuario;
import com.rodriguez.pruebas.repository.UsuarioRepository;
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
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@RequestMapping("api/usuario")
public class UsuarioController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Integer save(@RequestBody UsuarioDto usuarioDto ){
		Usuario usuario = MODEL_MAPPER.map(usuarioDto,Usuario.class);
		usuario = usuarioRepository.save(usuario);
		return usuario.getId();
	}


	@ResponseBody
	@GetMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{id}"
	) public Usuario findById(@PathVariable Integer id){
		Optional<Usuario> resultado = usuarioRepository.findById(id);
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
 * @return Page<Usuario> resultados encontrados.
 */
@ResponseBody
@GetMapping(
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.APPLICATION_JSON_VALUE,
value = "{pagina}/{cantidad}"
) public Page<Usuario> findAll(
	@PathVariable Integer pagina,
	@PathVariable Integer cantidad){

	Sort sort = Sort.by(Sort.Direction.ASC,"ID");
	Pageable pageable = PageRequest.of(pagina,cantidad,sort);
	return usuarioRepository.findAll(pageable);
}


@ResponseBody
@DeleteMapping(
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE,
	value = "{id}"
) public void delete(@PathVariable Integer id){
	usuarioRepository.deleteById(id);
}

}
