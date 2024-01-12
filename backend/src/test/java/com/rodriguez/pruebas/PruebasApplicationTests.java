
package com.rodriguez.pruebas;

import com.rodriguez.pruebas.controller.manyToOne.ArtistaController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Esta clase contiene pruebas de funcionamiento para
 * cada feature, haciendo que las futuras modificaciones/mantenimiento
 * sea predecible y pueda indicar claramente si se ha modificado algo
 * que ya funcionaba, cumpliendo algún objetivo concreto.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@SpringBootTest
@Profile("rolpruebas")
class PruebasApplicationTests {

	@Autowired
	private ArtistaController artistaController;

	@Test
	void contextLoads(ApplicationContext context) throws Exception {
		assertThat(context).isNotNull();
		assertThat(artistaController).isNotNull();
	}

}
