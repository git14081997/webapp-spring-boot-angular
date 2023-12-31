
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
@Table( name = "PRODUCTO", schema = "INVENTARIO_FACTURACION", catalog = "INVENTARIO_FACTURACION")
public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
	@Column( name = "ID", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;


    @Column( name = "NOMBRE", nullable = false, unique = true, length = 512)
    private String nombre;


	@Column( name = "COSTO_UNIDAD", scale = 2, nullable = false)
	private BigDecimal costoUnidad;


	@Column( name = "GANANCIA", scale = 2, nullable = false)
	private BigDecimal ganancia;


	@Column( name = "PRECIO_VENTA", scale = 2, nullable = false)
	private BigDecimal precioVenta; // Sin IVA, el IVA se pondrá al registrar venta


	@Column( name = "EXISTENCIAS", nullable = false )
	private Integer existencias;


	@UpdateTimestamp
	@Column( name = "FECHA_MODIFICADO")
	private Date fechaModificado;


	@Column( name = "FECHA_ADQUISICION")
	private Date fechaAdquisicion;


	@Column( name = "ESTADO", length = 1)
	private String estado; // A Activo I Inactivo
	// A activo, es no ha sido "borrado"
	// I Inactivo, es que ya fue "borrado".





	//@Column( name = "GENERO",length = 1)
	//private String genero;


	//@Column( name = "EDAD",length = 1)
	//private String edad;


	//@Column( name = "TALLA")
	//private String talla;


	//@Column( name = "LARGO", scale = 2)
	//private BigDecimal largo;


	//@Column( name = "ANCHO", scale = 2)
	//private BigDecimal ancho;


	//@Column( name = "PROFUNDIDAD", scale = 2)
	//private BigDecimal profundidad;


	//@Column( name = "COLOR")
	//private String color;


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
