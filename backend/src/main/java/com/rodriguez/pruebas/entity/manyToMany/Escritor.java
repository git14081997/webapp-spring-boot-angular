
package com.rodriguez.pruebas.entity.manyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
 * Esta clase es una abstracción de la entidad Escritor,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "ESCRITOR", schema = "DBDEV")
public class Escritor implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID", unique = true )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column( name = "NOMBRE", length = 255 )
	private String nombre;

	public Escritor(String nombre) {
		this.nombre = nombre;
	}

	@ManyToMany(mappedBy = "escritorList")
	@JsonIgnore // esto es necesario para evitar recursividad anidada sin fin, un bucle sin fin.
	// sino, al traer un libro traeria el autor y el autor traeria el libro y el libro traeria el autor
	// y asi sucesivamente en un bucle/ciclo sin fin.
	private List<Libro> libroList = new ArrayList<>();

}
