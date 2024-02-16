
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ImagenProducto;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ImagenProductoRepository;
import com.rodriguez.pruebas.service.inventarioFacturacion.IImagenService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	IImagenService imagenService;



	// http://localhost:8089/api/imagen
	@PostMapping( value = "0", produces = MediaType.APPLICATION_JSON_VALUE )
	public Long saveImage( @RequestBody MultipartFile fileimagen )
	{
		try
		{

			String nombreArchivo = fileimagen.getOriginalFilename();
			String extensionArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf("."));

			String nuevoNombreArchivo = UUID.randomUUID().toString() + "." + extensionArchivo;

			byte[] bytesImagen = fileimagen.getBytes();

			long sizeImagen = fileimagen.getSize();
			long maxSize = 1048576 * 2; // 2 Megabytes

			LOG.info(nombreArchivo);
			LOG.info(extensionArchivo);
			LOG.info(sizeImagen + "");
			LOG.info(nuevoNombreArchivo);

			if( sizeImagen > maxSize)
			{
				LOG.warn("Tamaño de archivo supera: " + maxSize );
			}
			if(
				!nombreArchivo.endsWith(".png") &&
				!nombreArchivo.endsWith(".jpg") &&
				!nombreArchivo.endsWith(".jpeg")
			)
			{
				LOG.warn("Solo se permiten imagenes '.jpg', '.jpeg', '.png'");
			}

			// crear carpeta
			String recursosApiRest = "src/main/resources/pic";
			File archivoDeDirectorio = new File(recursosApiRest);
			if(!archivoDeDirectorio.exists()){
				archivoDeDirectorio.mkdirs();
			}

			// se guarda imagen en servidor donde se ejecuta el api
			Path path = Paths.get(recursosApiRest + "/" + nuevoNombreArchivo );
			Files.write(path, bytesImagen);

			// Se guarda copia de imagen en base de datos.
			return imagenService.guardarImagenEnDb(bytesImagen);

		} catch (Exception exception)
		{
			LOG.warn(exception.getMessage());
		}
		return -1L;
	}











	// http://localhost:8089/api/image
	@PostMapping(
		//consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
		//consumes = MediaType.IMAGE_JPEG_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Long> guardarImagenEnDb(@RequestParam( "file" ) MultipartFile multipartFile ){

		try
		{
			byte[] bytesDeImagen = multipartFile.getBytes();

			Long idImagen = imagenService.guardarImagenEnDb(bytesDeImagen);

			// return "redirect:/";

			return new ResponseEntity<>(idImagen, HttpStatus.CREATED);

		}
		catch (IOException ioException)
		{
			ioException.printStackTrace();
			LOG.error( ioException.getLocalizedMessage() );
			LOG.error( ioException.getMessage() );

			return new ResponseEntity<>( -1L , HttpStatus.INTERNAL_SERVER_ERROR );

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

		// <img src="/api/archivo/file/1" alt="Imagen">

	} // getImagen


} // class
