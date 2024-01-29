
package com.rodriguez.pruebas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
@AutoConfiguration
public class PruebasApplication /*implements CommandLineRunner*/ {

	private static final Logger logger = LoggerFactory.getLogger(PruebasApplication.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public static void main(String[] args) {
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");

		SpringApplication.run(PruebasApplication.class, args);
	}


/*
@Override
public void run(String... strings) throws Exception {
System.out.println("Realizando pruebas rapidas");
log.info("Realizando pruebas rapidas");

jdbcTemplate.execute("INSERT INTO USUARIO(NOMBRE,APELLIDO,CORREO,CONTRASENA) VALUES('Juan','Robles','JROBLES2@GMAIL.COM', '123')");
jdbcTemplate.execute("INSERT INTO USUARIO(NOMBRE,APELLIDO,CORREO,CONTRASENA) VALUES('Victor', 'Hugo','VHUGO4@HOTMAIL.COM', '123')");
jdbcTemplate.execute("INSERT INTO USUARIO(NOMBRE,APELLIDO,CORREO,CONTRASENA) VALUES('Maria', 'Perez','MPEREZ24@YAHOO.COM', '123')");
jdbcTemplate.execute("INSERT INTO USUARIO(NOMBRE,APELLIDO,CORREO,CONTRASENA) VALUES('Estefani', 'Gomez','EGOMEZ52@OUTLOOK.COM', '123')");
}
*/


}
