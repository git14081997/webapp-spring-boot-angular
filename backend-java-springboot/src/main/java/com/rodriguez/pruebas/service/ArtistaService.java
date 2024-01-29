
package com.rodriguez.pruebas.service;

import com.rodriguez.pruebas.entity.manyToOne.Artista;
import com.rodriguez.pruebas.entity.manyToOne.Cancion;
import com.rodriguez.pruebas.repository.manyToOne.ArtistaRepository;
import com.rodriguez.pruebas.repository.manyToOne.CancionRepository;
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
@Service("ArtistaService")
@AllArgsConstructor
public class ArtistaService implements IArtistaService {


	private static final Logger log = LoggerFactory.getLogger(ArtistaService.class);


	@Autowired
    private ArtistaRepository artistaRepository;

	@Autowired
	private CancionRepository cancionRepository;


	@Override
	public Integer escribirCanciones(String nombre, Artista artista) {
		Cancion newCancion = new Cancion();
		newCancion.setNombre(nombre);
		newCancion.setArtista(artista);

		newCancion = cancionRepository.save(newCancion);

		return newCancion.getId();
	}


}
