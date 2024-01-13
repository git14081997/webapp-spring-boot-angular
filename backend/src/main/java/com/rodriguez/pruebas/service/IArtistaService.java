
package com.rodriguez.pruebas.service;

import com.rodriguez.pruebas.entity.manyToOne.Artista;

public interface IArtistaService {

	Integer escribirCanciones(String nombre, Artista artista);

}
