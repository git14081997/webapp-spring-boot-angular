
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
 * Esta clase es una abstracción de la entidad ClienteAbona,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "cliente_abona", schema = "inventario_facturacion", catalog = "inventario_facturacion")
public class ClienteAbona implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "id", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario cliente;

	@ManyToOne
	@JoinColumn(name = "factura_id")
	private Factura factura;

	@Column( name = "saldo_anterior", scale = 2)
	private BigDecimal saldoAnterior;

	@Column( name = "cargos", scale = 2)
	private BigDecimal cargos;

	@Column( name = "abonos", scale = 2)
	private BigDecimal abonos;

	@Column( name = "saldo", scale = 2)
	private BigDecimal saldo;

	@CreationTimestamp
	@Column( name = "fecha")
	private Date fecha;

	@Column(name = "detalles", length = 512)
	private String detalles;

}
