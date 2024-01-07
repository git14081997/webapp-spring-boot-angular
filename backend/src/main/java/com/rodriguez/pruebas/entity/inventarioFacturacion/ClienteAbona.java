
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
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "CLIENTE_ABONA", schema = "INVENTARIO_FACTURACION", catalog = "INVENTARIO_FACTURACION")
public class ClienteAbona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
	@Column( name = "ID", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario cliente;

	@ManyToOne
	@JoinColumn(name = "FACTURA_ID")
	private Factura factura;

	@Column( name = "SALDO_ANTERIOR", scale = 2)
	private BigDecimal saldoAnterior; // saldo historico

	@Column( name = "CARGOS", scale = 2)
	private BigDecimal cargos; // cliente se compro al credito

	@Column( name = "ABONOS", scale = 2)
	private BigDecimal abonos; // cliente paga parcial o totalmente su deuda por compras

	@Column( name = "SALDO", scale = 2)
	private BigDecimal saldo; // saldo actual, que cliente pagará eventualmente

	@CreationTimestamp
	@Column( name = "FECHA")
	private Date fecha;

	@Column(name = "DETALLES", length = 512)
	private String detalles;


}
