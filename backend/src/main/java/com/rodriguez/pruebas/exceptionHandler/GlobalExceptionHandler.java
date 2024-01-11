
package com.rodriguez.pruebas.exceptionHandler;

/**
 * Esta clase pretende gestionar las excepciones y mostrar ciertos detalles relevantes
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */

//@ControllerAdvice
public class GlobalExceptionHandler { //  extends ResponseEntityExceptionHandler {

	/*
	@ExceptionHandler( Exception.class )
	public ResponseEntity<Map<String,Object>> mostrarError(Exception exception, WebRequest webRequest){

		Map<String,Object> respuesta = new HashMap<>();

		respuesta.put("fecha", new Date());
		respuesta.put("error", exception.getMessage() );
		respuesta.put("causa", exception.getCause() );
		respuesta.put("contextPath", webRequest.getContextPath() );

		return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	 */

}
