
package com.rodriguez.pruebas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
//import org.springframework.context.annotation.Profile;


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
//@Profile("rolpruebas")
class PruebasApplicationTests {

	@Test
	void contextLoads(ApplicationContext applicationContext) throws Exception {

		assertThat(applicationContext).isNotNull();
	}

}
