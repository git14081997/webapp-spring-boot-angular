
package com.rodriguez.pruebas.repository.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.rowMapper.UsuarioRm;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class SpecialRepository {

	private static final Logger log = LoggerFactory.getLogger(SpecialRepository.class);


	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Getter @Setter
	private String sql;


	public List<Usuario> buscarCliente(String nombre){

		setSql("SELECT * FROM USUARIO WHERE NOMBRE LIKE = ?");

		// opcion1
		return jdbcTemplate.query(sql, new UsuarioRm());

		// opcion2
		/*
		return jdbcTemplate.query(sql,
			new BeanPropertyRowMapper<Usuario>(Usuario.class)
		);
		*/
	}


	public Integer count() {
		setSql("SELECT COUNT(*) FROM USUARIO");
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}


	public int save(Usuario usuario) {
		setSql("insert into USUARIO (correo, contrasena) values(?,?)");
		return jdbcTemplate.update(sql,
			usuario.getCorreo(), usuario.getContrasena()
		);
	}


	public int update(Usuario usuario) {
		setSql("update USUARIO set correo = ? where id = ?");
		return jdbcTemplate.update(sql,
			usuario.getCorreo(), usuario.getId()
		);
	}


	public int deleteById(Long id) {
		setSql("delete USUARIO where id = ?");
		return jdbcTemplate.update(sql, id);
	}





}
