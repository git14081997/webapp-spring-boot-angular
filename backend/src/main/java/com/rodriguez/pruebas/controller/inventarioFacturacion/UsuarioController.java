
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.UsuarioDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.UsuarioRepository;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
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
@RequestMapping("api/usuario")
public class UsuarioController {

	private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PutMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Integer update(@RequestBody UsuarioDto usuarioDto ){

		Integer usuarioId = usuarioDto.getId();

		if(usuarioId == null){
			return -1;
		}
		else {

			Optional<Usuario> usuarioEnDB = usuarioRepository.findById(usuarioId);

			if( usuarioEnDB.isPresent() ){
				Usuario usuarioReal = usuarioEnDB.get();

				usuarioReal.setNombre(usuarioDto.getNombre());
				usuarioReal.setNombreDos(usuarioDto.getNombreDos());

				usuarioReal.setApellido(usuarioDto.getApellido());
				usuarioReal.setApellidoDos(usuarioDto.getApellidoDos());

				usuarioReal.setCodigoArea(usuarioDto.getCodigoArea());
				usuarioReal.setTelefono(usuarioDto.getTelefono());

				usuarioReal.setDireccion(usuarioDto.getDireccion());

				usuarioReal.setNit(usuarioDto.getNit());

				usuarioReal.setCumpleanos(usuarioDto.getCumpleanos());

				//usuarioReal.setContrasena(usuarioDto.getContrasena());
				//usuarioReal.setCorreo(usuarioDto.getCorreo());

				usuarioRepository.save(usuarioReal);
				return 0;
			}
			else {
				return -2;
			}
		}
	}

	@ResponseBody
	@PostMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Integer save(@RequestBody UsuarioDto usuarioDto ){

		Integer usuarioId = usuarioDto.getId();

		if(usuarioId != null){
			return -1;
		}
		else {
			Usuario usuario = MODEL_MAPPER.map(usuarioDto,Usuario.class);

			if(usuario.getPendienteDePago() == null) {
				usuario.setPendienteDePago(new BigDecimal(0));
			}

			if(usuario.getBloqueado() == null) {
				usuario.setBloqueado("N");
			}

			usuario = usuarioRepository.save(usuario);
			return usuario.getId();
		}

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

	Sort sort = Sort.by(Sort.Direction.ASC,"id");
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


	@ResponseBody
	@PutMapping(
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		value = "{opcion}"
	)
	public Integer updateCorreoContrasena(
			@PathVariable Integer opcion,
			@RequestBody UsuarioDto usuarioDto ){

		Integer usuarioId = usuarioDto.getId();

		if(usuarioId == null){
			return -1;
		}
		else {

			Optional<Usuario> usuarioEnDB = usuarioRepository.findById(usuarioId);

			if( usuarioEnDB.isPresent() ){
				Usuario usuarioReal = usuarioEnDB.get();

				if( opcion == 0 ){
					usuarioReal.setContrasena(usuarioDto.getContrasena());
				}

				if( opcion == 1 ){
					usuarioReal.setCorreo(usuarioDto.getCorreo());
				}

				usuarioRepository.save(usuarioReal);
				return 0;
			}
			else {
				return -2;
			}
		}
	}






}
