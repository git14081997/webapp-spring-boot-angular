
package com.rodriguez.pruebas.repository.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.UsuarioDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SpecialRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public SpecialRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<Usuario> buscarCliente(String nombre){

		String queryBuscarClientePorNombre = """
			SELECT * FROM USUARIO WHERE NOMBRE LIKE = ?
		""";

		return jdbcTemplate.query(queryBuscarClientePorNombre, );
	}

	public int count() {
		String query = "SELECT COUNT(*) FROM USUARIO";
		return jdbcTemplate.queryForObject(query, Integer.class);
	}

	public int save(UsuarioDto usuarioDto) {
		String query = "insert into USUARIO (correo, contrasena) values(?,?)";
		return jdbcTemplate.update(query,
			usuarioDto.getCorreo(), usuarioDto.getContrasena()
		);
	}

	public int update(UsuarioDto usuarioDto) {
		String query = "update USUARIO set correo = ? where id = ?";
		return jdbcTemplate.update(query,
			usuarioDto.getCorreo(), usuarioDto.getId()
		);
	}

	public int deleteById(Long id) {
		String query = "delete USUARIO where id = ?";
		return jdbcTemplate.update(query, id);
	}




}
