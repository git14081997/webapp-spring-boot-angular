
package com.rodriguez.pruebas.entity.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PedidoDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer clienteId;

	private BigDecimal total;
	private BigDecimal iva;
	private BigDecimal ganancia;

}
