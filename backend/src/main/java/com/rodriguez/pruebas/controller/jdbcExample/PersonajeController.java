
package com.rodriguez.pruebas.controller.jdbcExample;

import com.rodriguez.pruebas.entity.jdbcExample.Personaje;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("api/personaje")
public class PersonajeController {

	private static final Logger log = LoggerFactory.getLogger(PersonajeController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public Personaje findById(@PathVariable Integer id){
		String sql = "SELECT * FROM DBDEV.PERSONAJE WHERE ID = ?";
		Personaje personaje = null;
		personaje =
		jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Personaje.class),id);
		return personaje;
	}


	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Personaje personajeDto ){
		String sql = "insert into DBDEV.PERSONAJE (nombre, puntos, fecha_guardado) values(?,?,?)";
		jdbcTemplate.update(sql,
			personajeDto.getNombre(), personajeDto.getPuntos(),personajeDto.getFechaGuardado()
		);
	}


	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Personaje personajeDto){
		String sql = "update DBDEV.PERSONAJE set nombre=?, puntos=?, fecha_guardado=? where id=?";
		jdbcTemplate.update(sql,
			personajeDto.getNombre(), personajeDto.getPuntos(),
			personajeDto.getFechaGuardado(), personajeDto.getId()
		);
	}


	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Personaje> findAll(){
		String sql = "SELECT * FROM DBDEV.PERSONAJE WHERE NOMBRE LIKE = ?";
		return jdbcTemplate.query(sql,
			new BeanPropertyRowMapper<Personaje>(Personaje.class)
		);
	}


	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		String sql = "delete from DBDEV.PERSONAJE where id=?";
		jdbcTemplate.update(sql, id);
	}


}
