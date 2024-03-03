
package com.rodriguez.pruebas.service.dbdev;

import com.rodriguez.pruebas.repository.dbdev.manyToOne.CancionRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase contiene la lógica de negocio.
 * Restricciones o controles en base a la necesidad del cliente.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@Service("CancionService")
@AllArgsConstructor
public class CancionService {

	private static final Logger log =
		LoggerFactory.getLogger(CancionService.class);

	@Autowired
	private CancionRepository cancionRepository;


}
