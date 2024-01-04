
package com.rodriguez.pruebas.controller.inventarioFacturacion;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
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



	/*
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Usuario usuario){

		// copia del saldo pendiente de pago, antes de cambiarlo
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getId());
		if(usuarioOptional.isPresent()){
			Usuario usuarioCopy = usuarioOptional.get();
			usuarioCopy.setPendienteDePagoCopy(usuarioCopy.getPendienteDePago());
			usuarioRepository.save(usuarioCopy);

			usuario.setPendienteDePagoCopy(usuarioCopy.getPendienteDePago());

			// actualizando datos
			usuarioRepository.save(usuario);
		}

	}

	 */




	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody Usuario usuario ){

		Integer usuarioId = usuario.getId();
		if(null == usuarioId){

			if(usuario.getNombreDos() == null){
				usuario.setNombreDos("");
			}
			if(usuario.getApellido() == null){
				usuario.setApellido("");
			}
			if(usuario.getApellidoDos() == null){
				usuario.setApellidoDos("");
			}

			usuario.setNombreCompleto(
			usuario.getNombre() + " " + usuario.getNombreDos() + " " + usuario.getApellido() + " " + usuario.getApellidoDos()
			);

			usuario.setPendienteDePago(new BigDecimal(0));
			usuario.setPendienteDePagoCopy(usuario.getPendienteDePago());

			usuario = usuarioRepository.save(usuario);
			return usuario.getId();
		}

		return -1;

		/*
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

			usuario.setNombreCompleto(
				usuario.getNombre() + " " +
				usuario.getNombreDos() + " " +
				usuario.getApellido() + " " +
				usuario.getApellidoDos()
			);

			usuario = usuarioRepository.save(usuario);
			return usuario.getId();

		 */
	}





	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public Usuario findById(@PathVariable Integer id){
		Optional<Usuario> resultado = usuarioRepository.findById(id);
		if(resultado.isPresent()){
			Usuario usuarioEncontrado = resultado.get();
			usuarioEncontrado.setContrasena("");

			usuarioEncontrado.setUsuarioCreo(null);
			usuarioEncontrado.setUsuarioModifico(null);

			usuarioEncontrado.setFechaCreado(null);
			usuarioEncontrado.setFechaModificado(null);

			return usuarioEncontrado;
		}
		return null;
	}



	/*
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	*/


	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Usuario> resultados encontrados.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
	public Page<Usuario> findAll(@PathVariable Integer pagina, @PathVariable Integer cantidad){

		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		Page<Usuario> resultado = usuarioRepository.findAll(pageable);

		List<Usuario> usuarios = resultado.getContent();
		usuarios.forEach( usuarioEncontrado -> {
			usuarioEncontrado.setContrasena("");

			usuarioEncontrado.setUsuarioCreo(null);
			usuarioEncontrado.setUsuarioModifico(null);

			usuarioEncontrado.setFechaCreado(null);
			usuarioEncontrado.setFechaModificado(null);

		});

		return resultado;
	}


/*
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		usuarioRepository.deleteById(id);
	}
*/



	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Usuario> resultados encontrados.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/buscar")
	public Page<Usuario> findAllByNombreAndApellido(
		@PathVariable Integer pagina, @PathVariable Integer cantidad,
		@RequestParam(required = true) String nombre,
		@RequestParam(required = false) String apellido
	){

		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		Page<Usuario> resultado;

		if( apellido != null) {
			resultado = usuarioRepository.findByNombreContainingIgnoreCaseAndApellidoContainingIgnoreCase(pageable,nombre,apellido);
		}
		else {
			resultado = usuarioRepository.findByNombreCompletoContainingIgnoreCase(pageable,nombre);
		}

		List<Usuario> usuarios = resultado.getContent();

		usuarios.forEach( usuarioEncontrado -> {
			usuarioEncontrado.setContrasena("");

			usuarioEncontrado.setUsuarioCreo(null);
			usuarioEncontrado.setUsuarioModifico(null);

			usuarioEncontrado.setFechaCreado(null);
			usuarioEncontrado.setFechaModificado(null);

		});





		return resultado;
	}


}
