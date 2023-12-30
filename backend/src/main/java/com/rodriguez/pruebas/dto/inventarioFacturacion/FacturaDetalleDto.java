
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Esta clase es una abstracción de la entidad FacturaDetalle,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Data
public class FacturaDetalleDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;
	private FacturaDto factura;
	private Integer cantidadProductoVendido;
	private BigDecimal precioVentaPorProducto;
	private BigDecimal subtotalPorProducto;
	private BigDecimal ivaDelSubtotalPorProducto;
	private BigDecimal costoUnidad;
	private BigDecimal costoDelSubtotalPorProducto;
	private BigDecimal gananciaDelSubtotalPorProducto;
	private ProductoDto producto;

}
