
package com.rodriguez.pruebas.dto.dbdev.manyToMany;

import com.rodriguez.pruebas.entity.dbdev.manyToMany.Libro;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class EscritorDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private List<Libro> libroList = new ArrayList<>();

	public EscritorDto(String nombre) {
		this.nombre = nombre;
	}

}
