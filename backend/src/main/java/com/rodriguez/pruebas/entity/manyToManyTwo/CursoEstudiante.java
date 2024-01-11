
package com.rodriguez.pruebas.entity.manyToManyTwo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * Esta clase es una abstracción de la entidad CURSO_ESTUDIANTE,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "CURSO_ESTUDIANTE", schema = "DBDEV", catalog = "DBDEV")
public class CursoEstudiante implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CursoEstudiantePk id;


//	@MapsId("cursoId")
//	@ManyToOne
//	@JoinColumn(name = "CURSO_ID")
//	private Curso curso;
//
//
//	@MapsId("estudianteId")
//	@ManyToOne
//	@JoinColumn(name = "ESTUDIANTE_ID")
//	private Estudiante estudiante;


	@Column( name = "DESCRIPCION", length = 255 )
	private String DESCRIPCION;

}
