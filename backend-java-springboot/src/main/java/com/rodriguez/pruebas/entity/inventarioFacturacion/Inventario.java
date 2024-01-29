
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
@Table( name = "INVENTARIO", schema = "INVENTARIO_FACTURACION", catalog = "INVENTARIO_FACTURACION")
public class Inventario implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    @Id
	@Column( name = "ID", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;


	@ManyToOne
	@JoinColumn(name = "PRODUCTO_ID")
	private Producto producto;


	@Column( name = "SALDO_ANTERIOR")
	private Integer saldoAnterior;


	@Column( name = "ENTRADAS")
	private Integer entradas;


	@Column( name = "SALIDAS")
	private Integer salidas;


	@Column( name = "EXISTENCIA")
	private Integer existencia;


	@CreationTimestamp
	@Column( name = "FECHA")
	private Date fecha;


}
