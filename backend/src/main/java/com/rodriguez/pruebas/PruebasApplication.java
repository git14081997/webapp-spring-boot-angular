
package com.rodriguez.pruebas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
//@EnableAutoConfiguration
//@ComponentScan
//@EnableJpaRepositories( basePackages = "com.rodriguez.pruebas.repository")
//@EntityScan( basePackages = "libentity.com.rodriguez.pruebas.entity" )
public class PruebasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebasApplication.class, args);
	}

	private void pruebas(){
		// recomendado usar StringBuilder
		// para textos muy largos que deben
		// agregarse por pocos o por parametros.
		StringBuilder querySQL = new StringBuilder(
		"texto muy largo"
		);
		querySQL.append("yfgdgf");
		System.out.println(querySQL);

String parrafo = """
query sql muy largo...
de muchas lineas = ?
""";

	}

}
