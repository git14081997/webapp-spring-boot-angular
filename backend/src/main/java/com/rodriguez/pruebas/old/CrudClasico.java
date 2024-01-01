
package com.rodriguez.pruebas.old;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudClasico {

	private static final Logger log = LoggerFactory.getLogger(CrudClasico.class);

	@Getter
	@Setter
	private String sql;

	private ConexionClasica conexionClasica;
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;



	public CrudClasico(ConexionClasica conexionClasica) {
		this.conexionClasica = conexionClasica;
		this.connection = this.conexionClasica.getConnection();
		this.prepareStatement = null;
		this.resultSet = null;
	}



	public void closeConnection() throws SQLException {
		this.resultSet.close();
		this.prepareStatement.close();
		this.connection.close();
	}




	public void insertOld(Usuario usuario) throws SQLException {
		setSql("INSERT INTO USUARIO(CORREO, CONTRASENA,NOMBRE,APELLIDO) values (?,?,?,?)");
		prepareStatement = connection.prepareStatement(sql);

		prepareStatement.setString(1, usuario.getCorreo());
		prepareStatement.setString(2, usuario.getContrasena());
		prepareStatement.setString(3, usuario.getNombre());
		prepareStatement.setString(4, usuario.getApellido());

		int out = prepareStatement.executeUpdate();

		if (out != 0) {
			log.info("Saved");
		} else {
			log.error("Save failed");
		}
		this.closeConnection();
	}


	public Usuario getOld(Integer id) throws SQLException {
		Usuario usuarioDto = null;
		setSql("SELECT NOMBRE, APELLIDO FROM USUARIO WHERE ID=?");
		prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, id);
		resultSet = prepareStatement.executeQuery();
		if (resultSet.next()) {
			usuarioDto = new Usuario();
			usuarioDto.setId(id);
			usuarioDto.setNombre(resultSet.getString("nombre"));
			usuarioDto.setApellido(resultSet.getString("apellido"));
			log.info("1 USUARIO CONSULTADO.");
		} else {
			log.error("NO EXISTE USUARIO CON ID " + id.toString());
		}
		this.closeConnection();
		return usuarioDto;
	}



	public void updateOld(Usuario usuarioDto) throws SQLException {
		setSql("UPDATE USUARIO SET NOMBRE=?, APELLIDO=? WHERE ID=?");
		prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, usuarioDto.getNombre());
		prepareStatement.setString(2, usuarioDto.getApellido());
		prepareStatement.setInt(3, usuarioDto.getId());
		int out = prepareStatement.executeUpdate();
		if (out != 0) {
			log.info("ACTUALIZADO");
		} else {
			log.error("NO EXISTE USUARIO CON ID " + usuarioDto.getId() + ", FALLO AL ACTUALIZAR");
		}
		this.closeConnection();
	}




	public void deleteOld(int id) throws SQLException {
		setSql("DELETE FROM USUARIO WHERE ID = ?");
		prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setInt(1, id);
		int out = prepareStatement.executeUpdate();
		if (out != 0) {
			log.info("ELIMINADO");
		} else {
			log.error("NO EXISTE USUARIO CON ID " + id + ", FALLO AL ELIMINAR");
		}
		this.closeConnection();
	}



	public List<Usuario> getAll() throws SQLException {
		setSql("SELECT ID, CORREO, CONTRASENA, NOMBRE, APELLIDO FROM USUARIO");
		List<Usuario> ans = new ArrayList<Usuario>();
		prepareStatement = connection.prepareStatement(sql);
		resultSet = prepareStatement.executeQuery();
		while (resultSet.next()) {
			Usuario emp = new Usuario();
			emp.setId(resultSet.getInt("id"));
			emp.setCorreo(resultSet.getString("correo"));
			emp.setContrasena(resultSet.getString("contrasena"));
			emp.setNombre(resultSet.getString("nombre"));
			emp.setApellido(resultSet.getString("apellido"));
			ans.add(emp);
		}
		this.closeConnection();
		return ans;
	}



}
