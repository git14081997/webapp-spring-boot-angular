
package com.rodriguez.pruebas.dto;

import com.rodriguez.pruebas.entity.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
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
@Data
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
	private Date fechaCreado;
	private Date fechaModificado;
	private String bloqueado;
	private String codigoArea;
	private String telefono;
	private Double dinero;
	private UsuarioDto usuarioModifico;

}
