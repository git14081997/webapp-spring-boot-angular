
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
import org.hibernate.annotations.CreationTimestamp;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Esta clase es una abstracción de la entidad Factura,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "factura", schema = "inventario_facturacion", catalog = "inventario_facturacion")
public class Factura implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "id", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario cliente;

	@Column(name = "tipo_pago", length = 1)
	private String tipoPago;

	@Column( name = "costo_total", scale = 2, nullable = false )
	private BigDecimal costoTotal;

	@Column( name = "ganancia", scale = 2, nullable = false )
	private BigDecimal ganancia;

	@Column( name = "iva", scale = 2, nullable = false )
	private BigDecimal iva;

	@Column( name = "subtotal_sin_iva", scale = 2, nullable = false )
	private BigDecimal subtotalSinIva;

	@Column( name = "total", scale = 2, nullable = false )
	private BigDecimal total;

	@CreationTimestamp
	@Column( name = "fecha_emision" )
	private Date fechaEmision;

	@Column( name = "nombre_completo", nullable = false )
	private String nombreCompleto;

	@Column( name = "fecha_devolucion" )
	private Date fechaDevolucion;

}
