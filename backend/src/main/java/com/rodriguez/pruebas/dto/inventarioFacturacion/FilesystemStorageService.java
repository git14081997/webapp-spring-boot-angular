
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesystemStorageService {

	@Value("${media.location}")
	private String medialocation;


	private Path rootLocation;


	public void init() throws IOException {
		rootLocation = Paths.get(medialocation);
		Files.createDirectories(rootLocation);
	}


	public String store(MultipartFile file){
		if(file.isEmpty()){
			throw new RuntimeException("archivo vacio o con error");
		}
		String filename = file.getOriginalFilename();

		if( filename == null || filename.isEmpty()){
			throw new RuntimeException("longitud del nombre de archivo es cero.");
		}
		else {

		Path destinationFile = rootLocation.resolve(Paths.get(filename))
				.normalize().toAbsolutePath();

		try(InputStream inputStream = file.getInputStream() ) {

		Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);


		} catch (IOException e) {
			throw new RuntimeException("error al guardar archivo");
		}
			return filename;

		}


	}


	public Resource loadResource(String filename){

		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if(resource.exists() || resource.isReadable()){
				return resource;
			}
			else {
				throw new RuntimeException("no se pudó leer el archivo de imagen1");
			}

		} catch (MalformedURLException malformedURLException) {
			throw new RuntimeException("no se pudó leer el archivo de imagen2");
		}
	}



}
