
package com.rodriguez.pruebas.dto.manyToMany;

import com.rodriguez.pruebas.entity.manyToMany.Escritor;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class LibroDto implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String titulo;
	private List<Escritor> escritorList = new ArrayList<>();
	public LibroDto(String titulo) {
		this.titulo = titulo;
	}
}
