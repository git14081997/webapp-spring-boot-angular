
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
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Esta clase es una abstracción de la entidad Usuario,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "usuario", schema = "inventario_facturacion", catalog = "inventario_facturacion") // minusculas o mayusculas
public class Usuario implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "id", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "nombre_completo", nullable = true, length = 512)
	private String nombreCompleto;

	@Column( name = "nombre", nullable = false, updatable = false)
	private String nombre;

	@Column( name = "nombre_dos", nullable = true)
	private String nombreDos;

	@Column( name = "apellido", nullable = true)
	private String apellido;

	@Column( name = "apellido_dos", nullable = true)
	private String apellidoDos;

	@Column( name = "pendiente_de_pago", scale = 2, nullable = false)
	private BigDecimal pendienteDePago;

	@Column( name = "comentarios", length = 512, nullable = true )
	private String comentarios;


	//@Column( name = "TELEFONO", length = 20, unique = true)
	//@Column( name = "TELEFONO")
	//private String telefono;


	//@Column( name = "CORREO", unique = true, nullable = false)
	//@Column( name = "CORREO")
	//private String correo;


	//@Column( name = "CONTRASENA")
	//private String contrasena;


	//@Column( name = "CUMPLEANOS")
	//private Date cumpleanos;


	//@CreationTimestamp
	//@Column( name = "FECHA_CREADO", updatable = false)
	//private Date fechaCreado;


	//@UpdateTimestamp
	//@Column( name = "FECHA_MODIFICADO")
	//private Date fechaModificado;

	//@Column( name = "BLOQUEADO", length = 1)
	//private String bloqueado;

	//@OneToOne
	//@JoinColumn(name="USUARIO_MODIFICO")
	//private Usuario usuarioModifico;

	//@OneToOne
	//@JoinColumn(name="USUARIO_CREO")
	//private Usuario usuarioCreo;

	//@Column( name = "NIT")
	//private String nit;

	//@Column( name = "DIRECCION")
	//private String direccion;

}
