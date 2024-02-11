
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class UpdateInventario implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer idProducto;
	private Integer entradasProducto;

}
