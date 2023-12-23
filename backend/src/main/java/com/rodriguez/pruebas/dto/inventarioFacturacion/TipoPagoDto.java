
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * Esta clase es una abstracción de la entidad Categoria,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Data
public class TipoPagoDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
	private Integer id;
    private String descripcion;
}
