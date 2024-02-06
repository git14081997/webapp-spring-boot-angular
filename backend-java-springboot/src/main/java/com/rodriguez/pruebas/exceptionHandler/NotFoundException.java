
package com.rodriguez.pruebas.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.io.Serial;

/**
 * Excepcion personalizada
 * @author Franklin Rodriguez
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND )
public class NotFoundException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;

	public NotFoundException(String mensaje){
		super(mensaje);
	}

}
