
package com.rodriguez.pruebas.entity.inventarioFacturacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "FACTURA", schema = "DBDEV")
public class Factura implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
	@Column( name = "ID", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario cliente;

	@Column( name = "TOTAL", scale = 2)
	private BigDecimal total;

	@Column( name = "FECHA_EMISION")
	private Date fechaEmision;

	@ManyToOne
	@JoinColumn(name = "TIPO_PAGO_ID")
	private TipoPago tipoPago;

}
