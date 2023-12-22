
package com.rodriguez.pruebas.entity.oneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase es una abstracción de la entidad AArtista,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "AARTISTA", schema = "DBDEV")
public class AArtista implements Serializable {

    @Serial
    private static final long serialVersionUID = 193445286905151910L;

    @Id
	@Column( name = "ID", unique = true )
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

    @Column( name = "NOMBRE", length = 255 )
    private String nombre;

	public AArtista(String nombre) {
		this.nombre = nombre;
	}


	@OneToMany
	@JoinColumn(name = "FK_AARTISTA_ID")
	// name es nombreCampo en Entidad en medio de List<CCancion>
	// es el FK, es decir CCancion.aartistaId -> AArtista.id
	private List<CCancion> cCancionList = new ArrayList<>();


}
