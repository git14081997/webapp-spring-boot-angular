
package com.rodriguez.pruebas.dto.dbdev.oneToMany;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class CCancionDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private Integer fkAartistaId;

}
