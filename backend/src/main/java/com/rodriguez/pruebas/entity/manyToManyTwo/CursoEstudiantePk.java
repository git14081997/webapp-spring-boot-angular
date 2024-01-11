
package com.rodriguez.pruebas.entity.manyToManyTwo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

/**
 * Esta clase es una llave primaria compuesta de la entidades CURSO y ESTUDIANTE,
 * y almacenará la información adicional que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@Data
@Embeddable
public class CursoEstudiantePk implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Column( name = "CURSO_ID" )
	private Integer cursoId;

	@Column( name = "ESTUDIANTE_ID" )
	private Integer estudianteId;

}
