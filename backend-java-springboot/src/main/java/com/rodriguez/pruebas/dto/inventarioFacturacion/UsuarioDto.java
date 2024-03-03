
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class UsuarioDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private String nombre;

	private String nombreDos;

	private String apellido;

	private String apellidoDos;

	private BigDecimal pendienteDePago;

} // class
