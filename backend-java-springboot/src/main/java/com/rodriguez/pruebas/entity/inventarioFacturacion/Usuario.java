
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
@Table( name = "USUARIO", schema = "INVENTARIO_FACTURACION", catalog = "INVENTARIO_FACTURACION")
public class Usuario implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "NOMBRE_COMPLETO", nullable = true)
	private String nombreCompleto;

	@Column( name = "NOMBRE", nullable = false, updatable = false)
	private String nombre;

	@Column( name = "NOMBRE_DOS", nullable = true)
	private String nombreDos;

	@Column( name = "APELLIDO", nullable = true)
	private String apellido;

	@Column( name = "APELLIDO_DOS", nullable = true)
	private String apellidoDos;

	@Column( name = "PENDIENTE_DE_PAGO", scale = 2, nullable = false)
	private BigDecimal pendienteDePago;

	@Column( name = "COMENTARIOS", length = 512, nullable = true )
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
