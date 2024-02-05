
package com.rodriguez.pruebas.service.dbdev;

import com.rodriguez.pruebas.entity.dbdev.manyToOne.Artista;

public interface IArtistaService {

	Integer escribirCanciones(String nombre, Artista artista);

}
