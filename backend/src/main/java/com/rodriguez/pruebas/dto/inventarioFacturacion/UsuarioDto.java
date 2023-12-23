
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
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
@Data
public class UsuarioDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private String nombreDos;

	private String apellido;

	private String apellidoDos;

	private String codigoArea;

	private String telefono;

	private String correo;

	private String contrasena;

	private Date cumpleanos;

	private Date fechaCreado;

	private Date fechaModificado;

	private String bloqueado;

	private UsuarioDto usuarioModifico;

	private UsuarioDto usuarioCreo;

	private BigDecimal pendienteDePago;

	private String nit;

	private String direccion;

}
