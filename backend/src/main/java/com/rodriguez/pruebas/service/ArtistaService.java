
package com.rodriguez.pruebas.service;

import com.rodriguez.pruebas.repository.ArtistaRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase contiene la lógica de negocio.
 * Restricciones o controles en base a la necesidad del cliente.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Service("ArtistaService")
@AllArgsConstructor
public class ArtistaService {

	private static final Logger log = LoggerFactory.getLogger(ArtistaService.class);

	@Autowired
    private ArtistaRepository artistaRepository;

}
