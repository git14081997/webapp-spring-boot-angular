
package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Factura;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Inventario;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public interface IServiceFactura {

public Map<String,Object> anularFactura(Integer facturaid );

public Inventario buscarUltimoRegistroDelInventarioDelProducto(Integer productoId);

public void agregarExistencias(Producto producto, int nuevasExistencias );

public void agregarAlInventario(Producto producto, Integer nuevasUnidades );

public void registrarAbono( Factura factura,
    Usuario cliente, Date fechaAnulacion,
    BigDecimal saldoAnterior, BigDecimal clientePaga );

public void registrarCargo( Factura factura, Usuario cliente, Date fecha, BigDecimal saldoAnterior, BigDecimal totalFactura );

}
