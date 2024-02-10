
package com.rodriguez.pruebas.entity.inventarioFacturacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
 * Esta clase es una abstracción de la entidad IngresoEgresos,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "ingresos_egresos", schema = "inventario_facturacion", catalog = "inventario_facturacion")
public class IngresosEgresos implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "id", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "ingresos", scale = 2)
	private BigDecimal ingresos;

	@Column( name = "egresos", scale = 2)
	private BigDecimal egresos;

	@CreationTimestamp
	@Column( name = "fecha")
	private Date fecha;

	@Column( name = "detalle", length = 512)
	private String detalle;

}
