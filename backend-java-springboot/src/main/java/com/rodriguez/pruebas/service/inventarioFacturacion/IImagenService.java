
package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.ImagenProducto;

public interface IImagenService {

	public Long guardarImagenEnDb(byte[] datosImagen);

	ImagenProducto getImagenConId(Long id);

} // interface
