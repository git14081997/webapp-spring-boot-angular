
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DetallePedidoDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer productoId;

	private Integer cantidadProductoVendido;

	private BigDecimal precioVentaPorProducto;

	private BigDecimal subtotalPorProducto;

	private BigDecimal ivaDelSubtotalPorProducto;

	private BigDecimal costoDelSubtotalPorProducto;

	private BigDecimal gananciaDelSubtotalPorProducto;

} // class 
