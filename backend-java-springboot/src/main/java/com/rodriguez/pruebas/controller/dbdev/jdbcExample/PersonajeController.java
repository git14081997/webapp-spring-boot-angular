
package com.rodriguez.pruebas.controller.dbdev.jdbcExample;

import com.rodriguez.pruebas.entity.dbdev.jdbcExample.Personaje;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

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
@RequestMapping("api/personaje")
public class PersonajeController {

	private static final Logger log = LoggerFactory.getLogger(PersonajeController.class);

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
		String sql = "SELECT * FROM DBDEV.PERSONAJE";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Personaje.class));
	}


	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		String sql = "delete from DBDEV.PERSONAJE where id=?";
		jdbcTemplate.update(sql, id);
	}


	// nombre=Chris&edad=25
	// @RequestParam(name = "nombre") String nombre, @RequestParam(name = "edad") Integer edad
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "search")
	public List<Personaje> findAllByName(@RequestParam(name = "nombre") String nombre){
		String sql = "SELECT * FROM DBDEV.PERSONAJE WHERE NOMBRE LIKE ?";
		String patronDeBusqueda = "%" + nombre + "%";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Personaje.class), patronDeBusqueda);
	}




	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "exec")
	public void ejecutarQuerysEspecializados(){

		/*

		ejemplo de insercion o ejecucion de 1 query

String sql = """
create table mytable (id integer, name varchar(100))
""";

String sql2 = """
INSERT INTO DBDEV.PERSONAJE(NOMBRE,PUNTOS)VALUES('JUAN',0)
""";
jdbcTemplate.execute(sql2);

*/




// ejemplo de insercion multiple
int cantidadInsert = 0;
List<String> nombresDB = new ArrayList<>();

nombresDB.add("juan");
nombresDB.add("jenny");
nombresDB.add("maria");
nombresDB.add("pedro");
nombresDB.add("marie");
nombresDB.add("juana");
nombresDB.add("cindy");

cantidadInsert = nombresDB.size();

String sqlTemp = "INSERT INTO DBDEV.PERSONAJE(NOMBRE) VALUES ('";

for( int contadorI = 0; contadorI < cantidadInsert; contadorI++ ){

	jdbcTemplate.execute(sqlTemp + ((String) nombresDB.get(contadorI)) + "')");

} /* for */
// ejemplo de insercion multiple






		// ejemplo de traer Integer o string
		String sqlConsultarNumero = "SELECT COUNT(ID) FROM DBDEV.PERSONAJE";
		Integer resultado = null;
		resultado = jdbcTemplate.queryForObject(sqlConsultarNumero, Integer.class);
		log.info( "" + resultado );



}




}
