
package com.rodriguez.pruebas.dto.dbdev.manyToOne;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * Esta clase es necesaria para transporte de datos,
 * no se deben usar/exponer entidades de la DB al usuario final.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@Data
public class CancionDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private ArtistaDto artista;

}
