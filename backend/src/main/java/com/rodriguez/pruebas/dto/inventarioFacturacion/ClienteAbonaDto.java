
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Esta clase es una abstracción de la entidad ClienteAbona,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Data
public class ClienteAbonaDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
	private Integer id;
	private FacturaDto factura;
	private BigDecimal valor;
	private Date fecha;
	private String detalles;

}
