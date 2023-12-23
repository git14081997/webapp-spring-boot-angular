
package com.rodriguez.pruebas.entity.oneToMany;

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
 * Esta clase es una abstracción de la entidad CCancion,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "CCANCION", schema = "DBDEV", catalog = "DBDEV")
public class CCancion implements Serializable {

    @Serial
    private static final long serialVersionUID = -8522389366852882686L;

    @Id
	@Column( name = "ID", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

    @Column( name = "NOMBRE", length = 255)
    private String nombre;

	@Column( name = "FK_AARTISTA_ID")
	private Integer fkAartistaId;

}
