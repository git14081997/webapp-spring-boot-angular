
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class Informacion implements Serializable  {

	@Serial
	private static final long serialVersionUID = 1L;

	private String msg;

	private int num;

	private Object any;

} // class

