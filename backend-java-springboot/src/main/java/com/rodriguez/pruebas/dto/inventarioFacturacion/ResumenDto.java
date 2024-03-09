
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ResumenDto {

	private BigDecimal ganancia;
	private BigDecimal costoTotal;
	private int mes;

}
