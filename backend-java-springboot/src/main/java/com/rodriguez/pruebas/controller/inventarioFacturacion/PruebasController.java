
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

/**
 * Esta clase contiene los endpoint para pruebas.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
//@CrossOrigin( origins = "http://localhost:4200" )
@AllArgsConstructor
@RequestMapping("noapi/pruebas")
public class PruebasController {

	private static final Logger logger = LoggerFactory.getLogger(PruebasController.class);

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void pruebas0(@RequestParam BigDecimal numA, @RequestParam BigDecimal numB){

		logger.warn("numA: " + numA.toString());
		logger.warn("numB: " + numB.toString());

		BigDecimal diferencia = numA.subtract(numB);
		logger.warn("numA - numB: " + diferencia.toString());

		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");

	}

}
