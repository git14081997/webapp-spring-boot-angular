
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ImagenProducto;
import com.rodriguez.pruebas.service.inventarioFacturacion.IServiceImage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Esta clase contiene los endpoint para subir imagenes.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
//@CrossOrigin( origins = "http://localhost:4200" )
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("api/image")
public class ArchivosController
{

	private static final Logger LOG = LoggerFactory.getLogger(ArchivosController.class);

	@Autowired
	IServiceImage imagenService;


// http://localhost:8089/api/image
@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Map<String,Object>> guardarImagenEnDb(
	@RequestParam( "file" ) MultipartFile multipartFile
) {

	Map<String, Object> resultado = new HashMap<>();
	int estadoHttp = 500;

	try
	{

		if(
		imagenService.tamanoDeArchivoEsMayorAlMaximoPermitido(multipartFile)
		){
			resultado.put("error", "El tamaño del archivo es mayor al máximo permitido !");
			estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR.value();
			return new ResponseEntity<>( resultado , HttpStatusCode.valueOf(estadoHttp));
		}

		Long imageId = imagenService.guardarImagenEnDb(multipartFile);

		imagenService.guardarEnSistemaDeArchivos(multipartFile, imageId.toString());

		// return "redirect:/";
		resultado.put("id", imageId);
		estadoHttp = HttpStatus.CREATED.value();
		return new ResponseEntity<>( resultado , HttpStatusCode.valueOf(estadoHttp));

	}
	catch (IOException ioException)
	{
		resultado.put("error", ioException.getMessage());
		estadoHttp = HttpStatus.INTERNAL_SERVER_ERROR.value();
		return new ResponseEntity<>( resultado , HttpStatusCode.valueOf(estadoHttp));
	} // catch


}





	// http://localhost:8089/api/image/{id}
	@GetMapping( value = "{id}", produces = MediaType.IMAGE_JPEG_VALUE )
	public ResponseEntity<byte[]> getImagen( @PathVariable Long id )
	{

		ImagenProducto imagenProducto = imagenService.getImagenConId( id );

		return ResponseEntity
			.ok()
			.contentType( MediaType.IMAGE_JPEG )
			.body( imagenProducto.getImagen() );

		// <img src="/api/image/1" alt="imagen">

	} // getImagen






} // class
