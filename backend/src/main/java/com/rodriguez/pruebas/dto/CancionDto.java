
package com.rodriguez.pruebas.dto;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * Esta clase es necesaria para transporte de datos,
 * no se deben usar/exponer entidades de la DB al usuario final.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Data
public class CancionDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -8522389366852882686L;
    private Long id;
    private String nombre;
	private ArtistaDto artista;
}
