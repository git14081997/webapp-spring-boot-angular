
package com.rodriguez.pruebas.repository.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.entity.jdbcExample.Personaje;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class SpecialRepository {

	private static final Logger log = LoggerFactory.getLogger(SpecialRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Getter @Setter
	private String sql;


	public List<Personaje> buscarPor(String nombre){

		setSql("SELECT * FROM DBDEV.PERSONAJE WHERE NOMBRE LIKE = ?");

		return jdbcTemplate.query(sql,
			new BeanPropertyRowMapper<Personaje>(Personaje.class)
		);
	}

	public Integer count() {
		setSql("SELECT COUNT(ID) FROM DBDEV.PERSONAJE");
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int save(Personaje personaje) {
		setSql("insert into DBDEV.PERSONAJE (correo, contrasena) values(?,?)");
		return jdbcTemplate.update(sql,
			personaje.getNombre(), personaje.getPuntos()
		);
	}

	public int update(Usuario usuario) {
		setSql("update DBDEV.PERSONAJE set correo = ? where id = ?");
		return jdbcTemplate.update(sql,
			usuario.getCorreo(), usuario.getId()
		);
	}

	public int deleteById(Long id) {
		setSql("delete DBDEV.PERSONAJE where id = ?");
		return jdbcTemplate.update(sql, id);
	}

}
