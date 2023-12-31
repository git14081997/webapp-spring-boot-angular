
package com.rodriguez.pruebas.entity.inventarioFacturacion;

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
 * Esta clase es una abstracción de la entidad Categoria,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "IMAGEN_PRODUCTO", schema = "INVENTARIO_FACTURACION", catalog = "INVENTARIO_FACTURACION")
public class ImagenProducto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "ID", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;

	@Column(name = "ARCHIVO")
	private byte[] archivo;

}
