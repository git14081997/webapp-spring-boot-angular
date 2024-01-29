
package com.rodriguez.pruebas.rowMapper;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import org.springframework.jdbc.core.RowMapper;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRm implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();

		usuario.setId(Integer.parseInt(rs.getString("id")));

		usuario.setPendienteDePago(new BigDecimal(rs.getString("pendienteDePago")));

		//usuario.setCorreo(rs.getString("correo"));
		usuario.setNombre(rs.getString("nombre"));
		usuario.setApellido(rs.getString("apellido"));

		// ... N campos

		return usuario;
	}

}
