
package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ImagenProducto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ImagenProductoRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImagenService implements IServiceImage {

	@Autowired
	private ImagenProductoRepository imagenProductoRepository;

	@Autowired
	private ProductoRepository productoRepository;


	public Long guardarImagenEnDb( MultipartFile multipartFile ) throws IOException
	{
		return this.guardarImagenEnDb( multipartFile.getBytes() );
	}


	public Long guardarImagenEnDb( byte[] datosImagen )
	{

		ImagenProducto imagenProducto = new ImagenProducto();

		imagenProducto.setImagen( datosImagen );

		imagenProducto = imagenProductoRepository.save( imagenProducto );

		return imagenProducto.getId();

	}



	@Override
	public ImagenProducto getImagenConId( Long id )
	{
		return imagenProductoRepository.getReferenceById(id);
	} // getImagenConId





	public void guardarEnSistemaDeArchivos( byte[] bytesImagen, String imageId ) throws IOException
	{

		final String rutaAlDirectorio = "src/main/resources/pic";

		File carpeta = new File( rutaAlDirectorio );

		if( !carpeta.exists() ){
			carpeta.mkdirs();
		}

		Path path = Paths.get( rutaAlDirectorio + "/" + imageId );

		Files.write( path, bytesImagen );

	} // guardarEnSistemasDeArchivos




	public void guardarEnSistemaDeArchivos( MultipartFile multipartFile, String imageId ) throws IOException
	{
		String nombreConExtension = imageId + getFileExtension(multipartFile);

		guardarEnSistemaDeArchivos(multipartFile.getBytes(), nombreConExtension);
	}



	public boolean tamanoDeArchivoEsMayorAlMaximoPermitido( MultipartFile multipartFile )
	{
		long sizeImagen = multipartFile.getSize();
		long maxSize = 1048576 * 2; // 2 Megabytes
		return sizeImagen > maxSize;
	}



	public String getFileExtension( MultipartFile multipartFile )
	{
		String nombreArchivo = multipartFile.getOriginalFilename();
		return nombreArchivo.substring( nombreArchivo.lastIndexOf(".") );
	}




public void guardarImagenEnProducto( Integer productoId,  Integer imageId ) {

Producto producto = productoRepository.getReferenceById(productoId);
producto.setImagen( imageId );
productoRepository.save(producto);

}



}
