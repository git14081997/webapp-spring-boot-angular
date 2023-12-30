
package com.rodriguez.pruebas.old;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionClasica {

	private final String DATABASE;
	private final String HOSTNAME;
	private final String PORT;
	private String url;
	private String username;
	private String password;
	private Connection connection;


	public ConexionClasica(String database, String hostname, String port,
		String username, String password){

		this.DATABASE = database;
		this.HOSTNAME = hostname;
		this.PORT = port;
		this.username = username;
		this.password = password;

		this.setUrl();

	}


	private void setUrl(){
		this.url = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE + "?useSSL=false";
	}



	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(url, username, password);
	}


	public Connection getConnection(){
		return this.connection;
	}


	public void closeConnection() throws SQLException {
		this.connection.close();
	}


	public Connection changeUser(String username,String password) throws SQLException, ClassNotFoundException {
		this.username = username;
		this.password = password;
		this.setUrl();
		this.conectar();
		return this.getConnection();
	}


}
