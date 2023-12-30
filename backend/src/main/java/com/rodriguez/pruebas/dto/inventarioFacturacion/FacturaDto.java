
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Esta clase es una abstracción de la entidad Factura,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Data
public class FacturaDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;
	private UsuarioDto cliente;
	private String nombre;
	private String apellido;
	private String nit;
	private String direccion;
	private TipoPagoDto tipoPago;
	private Date fechaEmision;
	private BigDecimal total;
	private BigDecimal iva;
	private BigDecimal ganancia;
	private BigDecimal pendienteDePago;

}
