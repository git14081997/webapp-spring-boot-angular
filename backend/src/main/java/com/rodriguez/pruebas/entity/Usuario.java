
package com.rodriguez.pruebas.entity;

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
@Table( name = "USUARIO", schema = "DBDEV")
public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
	@Column( name = "ID", unique = true )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

    @Column( name = "NOMBRE", length = 255 )
    private String nombre;

	@Column( name = "NOMBRE_DOS", length = 255 )
	private String nombreDos;

	@Column( name = "APELLIDO", length = 255 )
	private String apellido;

	@Column( name = "APELLIDO_DOS", length = 255 )
	private String apellidoDos;


	@Column( name = "CORREO", length = 255, unique = true,nullable = false)
	private String correo;

	@Column( name = "CONTRASENA", length = 255,nullable = false)
	private String contrasena;

	@Column( name = "CUMPLEANOS", updatable = false, nullable = false)
	private Date cumpleanos;

	@CreationTimestamp
	@Column( name = "CREADO", updatable = false, nullable = false)
	private Date creado;

	@Column( name = "ALTURA_METROS")
	private Double alturaMetros;

	@Column( name = "PESO_KG")
	private Double pesoKg;

	@Column( name = "TIPO_SANGRE", length = 20)
	private String tipoSangre;

	@Column( name = "BLOQUEADO", length = 1)
	private String bloqueado;

	@Column( name = "TELEFONO", length = 11)
	private String telefono;

	public Usuario(String correo, String contrasena) {
		this.correo = correo;
		this.contrasena = contrasena;
	}

}
