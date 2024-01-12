
package com.rodriguez.pruebas.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase pretende gestionar las excepciones y mostrar ciertos detalles relevantes
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler( Exception.class )
	public ResponseEntity<Map<String,Object>> mostrarError(Exception exception, WebRequest webRequest){

		Map<String,Object> respuesta = new HashMap<>();

		respuesta.put("fecha", new Date());
		respuesta.put("error", exception.getMessage() );
		respuesta.put("causa", exception.getCause() );
		respuesta.put("contextPath", webRequest.getContextPath() );
		respuesta.put("localizedMessage", exception.getLocalizedMessage() );
		respuesta.put("stackTrace", exception.getStackTrace() );

		return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
