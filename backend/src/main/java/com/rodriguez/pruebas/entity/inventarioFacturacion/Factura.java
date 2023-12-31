
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
	// cliente.usuarioId = 1


	@Column(name = "TIPO_PAGO", length = 8)
	private String tipoPago;
	// Venta en E 'Efectivo' 8  Factura
	// Venta al C 'Credito'  7  Factura sin pagar en el acto
	// V          'Visto'    5  Posible perdida si no pagan


	@Column( name = "GANANCIA", scale = 2, nullable = false )
	private BigDecimal ganancia;

	@Column( name = "IVA", scale = 2, nullable = false )
	private BigDecimal iva;

	@Column( name = "TOTAL", scale = 2, nullable = false )
	private BigDecimal total;

	@Column( name = "SUBTOTAL_SIN_IVA", scale = 2, nullable = false )
	private BigDecimal subtotalSinIva;

	@Column( name = "PENDIENTE_DE_PAGO", scale = 2, nullable = false )
	private BigDecimal pendienteDePago; // Venta al credito

	@CreationTimestamp
	@Column( name = "FECHA_EMISION", updatable = false )
	private Date fechaEmision;

	@Column( name = "NOMBRE_COMPLETO", nullable = false )
	private String nombreCompleto;

}
