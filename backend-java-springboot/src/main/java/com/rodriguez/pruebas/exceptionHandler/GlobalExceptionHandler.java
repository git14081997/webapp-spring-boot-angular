
package com.rodriguez.pruebas.exceptionHandler;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
*/

/**
 * Esta clase pretende gestionar las excepciones y mostrar ciertos detalles relevantes
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
//@ControllerAdvice
public class GlobalExceptionHandler // extends ResponseEntityExceptionHandler
{

	// SE DESHABILITA MANUALMENTE TEMPORALMENTE

/*
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


	@ExceptionHandler( Exception.class )
	public ResponseEntity<String> mostrarError(Exception exception, WebRequest webRequest)
	{

		logger.warn( "causa: " + exception.getCause().toString() );

		//return new ResponseEntity<>(exception.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}


*/
}
