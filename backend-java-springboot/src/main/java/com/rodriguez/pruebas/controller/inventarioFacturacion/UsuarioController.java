
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.UsuarioDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.UsuarioRepository;
import com.rodriguez.pruebas.service.inventarioFacturacion.IUsuarioService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
//@CrossOrigin( origins = "http://localhost:4200" )
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("api/usuario")
public class UsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ClienteAbonaRepository clienteAbonaRepository;

	@Autowired
	private IUsuarioService usuarioService;


	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateComentarios(@RequestBody Usuario dto){

		String newFullname = "";

		Optional<Usuario> usuarioOptional = usuarioRepository.findById(dto.getId());

		if(usuarioOptional.isPresent()){

			Usuario usuarioDB = usuarioOptional.get();

			String comentarios = dto.getComentarios();
			if( comentarios != null ){
				usuarioDB.setComentarios(comentarios);
			}


			String nombre = dto.getNombre();
			if( nombre != null ){
				nombre = nombre.trim();
				usuarioDB.setNombre(nombre);
				newFullname = nombre;
			}


			String nombreDos = dto.getNombreDos();
			if( nombreDos != null ){
				nombreDos = nombreDos.trim();
				usuarioDB.setNombreDos(nombreDos);
				newFullname += " " + nombreDos;
			}

			String apellido = dto.getApellido();
			if( apellido != null ){
				apellido = apellido.trim();
				usuarioDB.setApellido(apellido);
				newFullname += " " + apellido;
			}


			String apellidoDos = dto.getApellidoDos();
			if( apellidoDos != null ){
				apellidoDos = apellidoDos.trim();
				usuarioDB.setApellidoDos(apellidoDos);
				newFullname += " " + apellidoDos;
			}

			usuarioDB.setNombreCompleto(newFullname);
			usuarioRepository.save(usuarioDB);
		}

	}






	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Integer> save(@RequestBody UsuarioDto dto )
	{
		Integer usuarioId = usuarioService.guardar(dto);
		return new ResponseEntity<>(usuarioId, HttpStatus.CREATED);
	}







	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public Usuario findById(@PathVariable Integer id){
		Optional<Usuario> resultado = usuarioRepository.findById(id);
		if(resultado.isPresent()){
			Usuario usuarioEncontrado = resultado.get();
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
		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return usuarioRepository.findAll(pageable);
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
	@PathVariable Integer pagina, @PathVariable Integer cantidad, @RequestParam(required = true) String nombre)
	{

		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		try
		{
			Integer usuarioId = Integer.parseInt(nombre);
			return usuarioRepository.findByNombreCompletoContainingIgnoreCaseOrId(
				pageable, nombre, usuarioId
			);
		}
		catch (NumberFormatException numberFormatException)
		{
			return usuarioRepository.findByNombreCompletoContainingIgnoreCaseOrId(
				pageable, nombre, null
			);
		}
	}










	@Transactional
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "upload")
	public ResponseEntity<Map<String,String>> saveN(@RequestBody List<UsuarioDto> usuarios)
	{
		int procesados = 0;
		for( UsuarioDto usuarioN : usuarios )
		{
			save(usuarioN);
			procesados++;
		}

		Map<String,String> respuesta = new HashMap<>();

		respuesta.put( "in", usuarios.size() + "" );
		respuesta.put( "out", procesados + "" );

		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}



}
