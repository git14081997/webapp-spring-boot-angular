
package com.rodriguez.pruebas.entity.inventarioFacturacion;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import static jakarta.persistence.FetchType.LAZY;

/**
 * Esta clase es una abstracción de la entidad Categoria,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "imagen_producto", schema = "inventario_facturacion", catalog = "inventario_facturacion")
public class ImagenProducto implements Serializable {

/*
CREATE TABLE imagen_producto (
id INT AUTO_INCREMENT PRIMARY KEY,
imagen LONGBLOB
);
*/

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "id", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Basic( fetch = LAZY )
	@Lob
	@Column( name = "imagen", columnDefinition = "LONGBLOB" )
	private byte[] imagen;

}
