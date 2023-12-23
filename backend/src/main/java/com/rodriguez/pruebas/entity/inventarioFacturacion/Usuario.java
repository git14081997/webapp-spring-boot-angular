
package com.rodriguez.pruebas.entity.inventarioFacturacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Esta clase es una abstracción de la entidad Usuario,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
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

    @Column( name = "NOMBRE")
    private String nombre;

	@Column( name = "NOMBRE_DOS")
	private String nombreDos;

	@Column( name = "APELLIDO")
	private String apellido;

	@Column( name = "APELLIDO_DOS")
	private String apellidoDos;

	@Column( name = "CODIGO_AREA", length = 3)
	private String codigoArea;

	@Column( name = "TELEFONO", length = 8, unique = true)
	private String telefono;

	@Column( name = "CORREO", unique = true)
	private String correo;

	@Column( name = "CONTRASENA")
	private String contrasena;

	@Column( name = "CUMPLEANOS")
	private Date cumpleanos;

	@CreationTimestamp
	@Column( name = "FECHA_CREADO", updatable = false)
	private Date fechaCreado;

	@UpdateTimestamp
	@Column( name = "FECHA_MODIFICADO")
	private Date fechaModificado;

	@Column( name = "BLOQUEADO", length = 1)
	private String bloqueado;

	@OneToOne
	@JoinColumn(name="USUARIO_MODIFICO")
	private Usuario usuarioModifico;

	@OneToOne
	@JoinColumn(name="USUARIO_CREO")
	private Usuario usuarioCreo;

	@Column( name = "PENDIENTE_DE_PAGO", scale = 2)
	private BigDecimal pendienteDePago;

	@Column( name = "NIT")
	private String nit;

	@Column( name = "DIRECCION")
	private String direccion;


}
