
package com.rodriguez.pruebas.dto.dbdev.oneToMany;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AArtistaDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private List<CCancionDto> cCancionList = new ArrayList<>();

	public AArtistaDto(String nombre) {
		this.nombre = nombre;
	}

}
