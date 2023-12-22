
package com.rodriguez.pruebas.dto;

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
public class UsuarioDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;
	private String nombreDos;
	private String apellido;
	private String apellidoDos;
	private String correo;
	private String contrasena;
	private Date cumpleanos;
	private Double alturaMetros;
	private Double pesoKg;
	private String tipoSangre;
	private String bloqueado;
	private String telefono;

	public UsuarioDto(String correo, String contrasena) {
		this.correo = correo;
		this.contrasena = contrasena;
	}

}
