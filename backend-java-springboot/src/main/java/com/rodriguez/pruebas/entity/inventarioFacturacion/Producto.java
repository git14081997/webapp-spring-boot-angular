
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
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Esta clase es una abstracción de la entidad Producto,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "producto", schema = "inventario_facturacion", catalog = "inventario_facturacion")
public class Producto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "id", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;


	@Column( name = "nombre", nullable = false, unique = true, length = 512, updatable = false )
	private String nombre;


	@Column( name = "costo_unidad", scale = 2, nullable = false)
	private BigDecimal costoUnidad;


	@Column( name = "ganancia", scale = 2, nullable = false)
	private BigDecimal ganancia;


	@Column( name = "precio_venta", scale = 2, nullable = false)
	private BigDecimal precioVenta; // Sin IVA, el IVA se pondrá al registrar venta


	@Column( name = "existencias", nullable = false )
	private Integer existencias;


	@UpdateTimestamp
	@Column( name = "fecha_modificado")
	private Date fechaModificado;


	@Column( name = "fecha_adquisicion")
	private Date fechaAdquisicion;


	//@CreationTimestamp
	//@Column( name = "FECHA_CREADO", updatable = false)
	//private Date fechaCreado;


	//@ManyToOne
	//@JoinColumn(name = "USUARIO_MODIFICO")
	//private Usuario usuarioModifico;


	//@ManyToOne
	//@JoinColumn(name="USUARIO_CREO")
	//private Usuario usuarioCreo;




	////// revision pendiente
	//@Lob
	//@Column(name = "IMAGEN",columnDefinition="LONGBLOB")
	//private byte[] imagen;

	//@OneToOne
	//@JoinColumn(name="IMAGEN_PRODUCTO")
	//private ImagenProducto imagenProducto;
	///// revision pendiente

	// extras - extras - extras

}
