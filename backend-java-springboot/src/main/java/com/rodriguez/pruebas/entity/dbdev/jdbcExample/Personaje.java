
package com.rodriguez.pruebas.entity.dbdev.jdbcExample;

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
import java.util.Date;

/**
 * Esta clase es una abstracción de la entidad Personaje,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "PERSONAJE", schema = "DBDEV", catalog = "DBDEV")
public class Personaje implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID", unique = true )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "NOMBRE", length = 27, unique = true )
	private String nombre;

	@Column( name = "PUNTOS", scale = 2)//, nullable = false )
	private BigDecimal puntos;

	@Column( name = "FECHA_GUARDADO" )
	private Date fechaGuardado;

}
