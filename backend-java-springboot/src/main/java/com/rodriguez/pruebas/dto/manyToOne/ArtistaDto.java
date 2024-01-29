
package com.rodriguez.pruebas.dto.manyToOne;

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
public class ArtistaDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 193445286905151910L;

    private Long id;
    private String nombre;

}
