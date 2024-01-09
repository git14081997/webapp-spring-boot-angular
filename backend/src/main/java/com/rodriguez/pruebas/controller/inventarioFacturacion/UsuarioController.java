
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ClienteAbona;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;


/**
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @author Franklin Rodriguez
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
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ClienteAbonaRepository clienteAbonaRepository;




	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Usuario dto){

		Optional<Usuario> usuarioOptional = usuarioRepository.findById(dto.getId());

		if(usuarioOptional.isPresent()){

			Usuario usuarioDB = usuarioOptional.get();



			usuarioRepository.save(usuarioDB);

		}

	}






	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody Usuario usuario ){

		BigDecimal cero = new BigDecimal(0);

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

			usuario.setPendienteDePago(cero);

			ClienteAbona clienteAbona = new ClienteAbona();
			clienteAbona.setSaldo(cero);
			clienteAbona.setSaldoAnterior(cero);
			clienteAbona.setCargos(cero);
			clienteAbona.setAbonos(cero);
			clienteAbona.setDetalles("Saldo inicial");
			clienteAbona.setFactura(null);

			usuario = usuarioRepository.save(usuario);

			clienteAbona.setCliente( usuario );
			clienteAbonaRepository.save(clienteAbona);

			return usuario.getId();
		}

		return -1;
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
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
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
@PathVariable Integer pagina, @PathVariable Integer cantidad, @RequestParam(required = true) String nombre){

		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		return usuarioRepository.findByNombreCompletoContainingIgnoreCase(pageable, nombre);
	}



}
