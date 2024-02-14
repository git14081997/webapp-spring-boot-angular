
package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ImagenProducto;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ImagenProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenService implements IImagenService {

	@Autowired
	private ImagenProductoRepository imagenProductoRepository;

	public Long guardarImagenEnDb(byte[] datosImagen){

		ImagenProducto imagenProducto = new ImagenProducto();

		imagenProducto.setImagen( datosImagen );

		imagenProducto = imagenProductoRepository.save( imagenProducto );

		return imagenProducto.getId();

	}



	@Override
	public ImagenProducto getImagenConId(Long id)
	{
		return imagenProductoRepository.getReferenceById(id);
	} // getImagenConId




}
