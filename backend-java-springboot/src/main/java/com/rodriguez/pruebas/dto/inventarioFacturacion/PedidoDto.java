
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PedidoDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer usuarioId;

	private BigDecimal costoTotal;

	private BigDecimal ganancia;

	private BigDecimal iva;

	private BigDecimal subtotal;

	private BigDecimal total;

	private String tipoPago;

	private List<DetallePedidoDto> detalle;

}
