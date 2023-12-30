
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.CategoriaDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Categoria;
import com.rodriguez.pruebas.repository.inventarioFacturacion.CategoriaRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
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
@NoArgsConstructor
@RequestMapping("api/categoria")
public class CategoriaController {

	private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody CategoriaDto categoriaDto ){
		Categoria categoria = MODEL_MAPPER.map(categoriaDto, Categoria.class);
		categoria = categoriaRepository.save(categoria);
		return categoria.getId();
	}


	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public Categoria findById(@PathVariable Integer id){
		Optional<Categoria> resultado = categoriaRepository.findById(id);
		return resultado.orElse(null);
	}


	/*
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	*/


	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Categoria> resultados encontrados.
	 */
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
	public Page<Categoria> findAll(@PathVariable Integer pagina, @PathVariable Integer cantidad){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return categoriaRepository.findAll(pageable);
	}


	@ResponseBody
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		categoriaRepository.deleteById(id);
	}



	@ResponseBody
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer update(@RequestBody CategoriaDto categoriaDto ){

		Integer tmpId = categoriaDto.getId();

		if(tmpId == null){
			return -1;
		}
		else {

			Optional<Categoria> categoriaEnDB = categoriaRepository.findById(tmpId);

			if( categoriaEnDB.isPresent() ){
				Categoria categoriaReal = categoriaEnDB.get();
				categoriaReal.setDescripcion(categoriaDto.getDescripcion());
				categoriaRepository.save(categoriaReal);
				return 0;
			}
			else {
				return -2;
			}
		}
	}



	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Categoria> resultados encontrados.
	 */
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/buscar")
	public Page<Categoria> findAllByDescripcion(
			@PathVariable Integer pagina, @PathVariable Integer cantidad,
			@RequestParam(required = true) String descripcion){

		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		return categoriaRepository.findByDescripcionContainingIgnoreCase(pageable, descripcion);
	}



}
