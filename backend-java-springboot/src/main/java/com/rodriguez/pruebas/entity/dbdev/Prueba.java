
package com.rodriguez.pruebas.entity.dbdev;

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
@Table( name = "PRUEBA", schema = "DBDEV", catalog = "DBDEV")
public class Prueba implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "TEXTO_LARGO", length = 255, updatable = false, nullable = false)
	private String textoLargo;

	@Column( name = "PUNTOS_VIDA", scale = 2)
	private BigDecimal puntosVida;

}
