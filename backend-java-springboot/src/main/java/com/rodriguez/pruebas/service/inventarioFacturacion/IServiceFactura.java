
package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Factura;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Inventario;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public interface IServiceFactura {


public Map<String, Object> anularFactura( Integer facturaid );


public Inventario buscarUltimoRegistroDelInventarioDelProducto(Integer productoId);


public void agregarExistencias( Producto productoDB, int nuevasUnidades );


public void agregarAlInventario( Producto producto, Integer nuevasUnidades );


public void abonarAlCliente(
	Usuario cliente, BigDecimal clientePaga,
	Factura factura, Date fecha,
	String detalles
);


public void registrarAbono(
	Factura factura,
	Usuario cliente,
	Date fechaAnulacion,
	BigDecimal saldoAnterior,
	BigDecimal clientePaga,
	String detalles
);


public void registrarCargo(
	Factura factura,
	Usuario cliente,
	Date fecha,
	BigDecimal saldoAnterior,
	BigDecimal totalFactura
);


public void marcarFacturaComoAnulada(Factura factura, Date fechaAnulacion);


public void registrarIngreso(BigDecimal egreso, Date fecha, String detalles);


}
