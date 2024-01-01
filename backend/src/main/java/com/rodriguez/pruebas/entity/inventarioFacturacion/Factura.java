
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
@Table( name = "FACTURA", schema = "INVENTARIO_FACTURACION", catalog = "INVENTARIO_FACTURACION")
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

	@Column( name = "NOMBRE_COMPLETO")
	private String nombreCompleto;

	@Column( name = "NIT")
	private String nit;

	@Column( name = "DIRECCION")
	private String direccion;

	@Column(name = "TIPO_PAGO_ID", length = 1)
	private String tipoPago;
	// Venta en efectivo 'E'
	// Venta al credito  'C'
	//
	// E Efectivo; C Credito; V Visto

	@Column( name = "FECHA_EMISION")
	private Date fechaEmision;

	@Column( name = "TOTAL", scale = 2)
	private BigDecimal total;

	@Column( name = "IVA", scale = 2)
	private BigDecimal iva;

	@Column( name = "GANANCIA", scale = 2)
	private BigDecimal ganancia;

	@Column( name = "PENDIENTE_DE_PAGO", scale = 2)
	private BigDecimal pendienteDePago;

}
