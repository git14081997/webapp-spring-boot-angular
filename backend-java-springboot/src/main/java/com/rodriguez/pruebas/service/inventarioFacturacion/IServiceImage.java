
package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ImagenProducto;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface IServiceImage {


public void guardarEnSistemaDeArchivos( byte[] bytesImagen, String imageId ) throws IOException;


public void guardarEnSistemaDeArchivos( MultipartFile multipartFile, String imageId ) throws IOException;


public ImagenProducto getImagenConId(Long id);


public Long guardarImagenEnDb(byte[] datosImagen);


public Long guardarImagenEnDb(MultipartFile multipartFile) throws IOException;


public boolean tamanoDeArchivoEsMayorAlMaximoPermitido( MultipartFile multipartFile );


public String getFileExtension( MultipartFile multipartFile );



} // interface
