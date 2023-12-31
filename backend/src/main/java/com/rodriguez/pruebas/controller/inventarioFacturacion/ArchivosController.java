
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ImagenProducto;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ImagenProductoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
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
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("api/archivo")
public class ArchivosController {

	private static final Logger log = LoggerFactory.getLogger(ArchivosController.class);

	@Autowired
	private ImagenProductoRepository imagenProductoRepository;


	@PostMapping(value = "pic",produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer saveImage(@RequestBody MultipartFile fileimagen){
		try {

			String nombreArchivo = fileimagen.getOriginalFilename();
			String extensionArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf("."));

			String nuevoNombreArchivo = UUID.randomUUID().toString() + "." + extensionArchivo;

			byte[] bytesImagen = fileimagen.getBytes();

			long sizeImagen = fileimagen.getSize();
			long maxSize = 1048576 * 2; // 2 Megabytes

			log.info(nombreArchivo);
			log.info(extensionArchivo);
			log.info(sizeImagen + "");
			log.info(nuevoNombreArchivo);

			if( sizeImagen > maxSize){
				log.warn("Tamaño de archivo supera: " + maxSize );
			}
			if(!nombreArchivo.endsWith(".png") && !nombreArchivo.endsWith(".jpg") && !nombreArchivo.endsWith(".jpeg")){
				log.warn("Solo se permiten imagenes '.jpg', '.jpeg', '.png'");
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
			ImagenProducto imagenProducto = new ImagenProducto();
			imagenProducto.setArchivo(bytesImagen);
			imagenProducto =
					imagenProductoRepository.save(imagenProducto);

			return imagenProducto.getId();
		} catch (Exception exception) {
			log.warn(exception.getMessage());
		}
		return -1;
	}




	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "pic/{id}")
	public ImagenProducto findById(@PathVariable Integer id){
		Optional<ImagenProducto> resultado = imagenProductoRepository.findById(id);
		return resultado.orElse(null);
	}



	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "pic")
	public List<ImagenProducto> findById(@RequestBody List<Integer> imagenesid){

		List<ImagenProducto> imagenes = new ArrayList<>();

		for(Integer idN : imagenesid){
			ImagenProducto imagenProductoN = this.findById(idN);
			if(imagenProductoN != null) {
				imagenes.add(imagenProductoN);
			}
		}

		return imagenes;
	}

}
