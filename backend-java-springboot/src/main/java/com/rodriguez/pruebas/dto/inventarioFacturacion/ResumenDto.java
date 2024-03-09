
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ResumenDto {

	private BigDecimal ganancia;
	private BigDecimal costoTotal;
	private int mes;

}
