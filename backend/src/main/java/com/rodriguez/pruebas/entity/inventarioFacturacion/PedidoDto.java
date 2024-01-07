
package com.rodriguez.pruebas.entity.inventarioFacturacion;

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

	private BigDecimal ganancia;
	private BigDecimal iva;
	private BigDecimal total;
	private BigDecimal subtotal;

	private String tipoPago;

	private List<DetallePedidoDto> detalle;

}
