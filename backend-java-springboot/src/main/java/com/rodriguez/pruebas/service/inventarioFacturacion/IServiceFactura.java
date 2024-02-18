
package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Inventario;

import java.util.Map;

public interface IServiceFactura {

public Map<String,Object> anularFactura(Integer facturaid );

public Inventario buscarUltimoRegistroDelInventarioDelProducto(Integer productoId);


}
