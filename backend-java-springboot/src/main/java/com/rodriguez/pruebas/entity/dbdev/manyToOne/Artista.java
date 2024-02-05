
package com.rodriguez.pruebas.entity.dbdev.manyToOne;

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

/**
 * Esta clase es una abstracción de la entidad Artista,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "ARTISTA", schema = "DBDEV", catalog = "DBDEV")
public class Artista implements Serializable {

    @Serial
    private static final long serialVersionUID = 193445286905151910L;

    @Id
	@Column( name = "ID", unique = true )
	// opcion1
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	/*
	// opcion2 detalle1
	@SequenceGenerator(
		name = "seq_artista", sequenceName = "seq_artista",
		initialValue = 1, allocationSize = 1
	)
	// opcion2 detalle2
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "seq_artista"
	)
	*/
	private Integer id;


    @Column( name = "NOMBRE", length = 255, unique = true )
    private String nombre;

	public Artista(String nombre) {
		this.nombre = nombre;
	}

}
