
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
import java.util.Date;

/**
 * Esta clase es una abstracción para registrar entradas y salidas por producto
 * y almacenará la información de las existencias del mismo en el inventario.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "inventario", schema = "inventario_facturacion", catalog = "inventario_facturacion")
public class Inventario implements Serializable {


	@Serial
	private static final long serialVersionUID = 1L;


	@Id
	@Column( name = "id", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;


	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;


	@Column( name = "saldo_anterior")
	private Integer saldoAnterior;


	@Column( name = "entradas")
	private Integer entradas;


	@Column( name = "salidas")
	private Integer salidas;


	@Column( name = "existencia")
	private Integer existencia;


	@CreationTimestamp
	@Column( name = "fecha")
	private Date fecha;


}
