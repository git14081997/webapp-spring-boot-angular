
package com.rodriguez.pruebas.entity.dbdev.manyToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es una abstracción de la entidad Libro,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "LIBRO")//, schema = "DBDEV", catalog = "DBDEV")
public class Libro implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID", unique = true )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "TITULO", length = 255 )
	private String titulo;

	public Libro(String titulo) {
		this.titulo = titulo;
	}

	@ManyToMany
	@JoinTable(
		name = "LIBRO_ESCRITOR", schema = "DBDEV", catalog = "DBDEV",
		joinColumns = @JoinColumn(name = "LIBRO_ID"),
		inverseJoinColumns = @JoinColumn(name = "ESCRITOR_ID")
	)
	private List<Escritor> escritorList = new ArrayList<>();
	// escritorList es el nombre que usaré en la entidad Escritor,
	// en el siguiente apartado
	// ==
	// == 	@ManyToMany(mappedBy = "escritorList")
	// ==	private List<Libro> libroList = new ArrayList<>();
	// ==

}
