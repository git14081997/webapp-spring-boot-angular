
package com.rodriguez.pruebas.entity.manyToOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;

/**
 * Esta clase es una abstracción de la entidad Cancion,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "CANCION", schema = "DBDEV")
public class Cancion implements Serializable {

    @Serial
    private static final long serialVersionUID = -8522389366852882686L;

    @Id
	@Column( name = "ID", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

    @Column( name = "NOMBRE", length = 255)
    private String nombre;

	@ManyToOne
	@JoinColumn(name = "ARTISTA_ID")
	private Artista artista;

}
