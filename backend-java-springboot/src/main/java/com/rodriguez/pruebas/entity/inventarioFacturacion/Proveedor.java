
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
 * Esta clase es una abstracción de la entidad Proveedor,
 * y almacenará la información que se desee.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "proveedor")//, schema = "inventario_facturacion", catalog = "inventario_facturacion")
public class Proveedor implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column( name = "id", unique = true)
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Integer id;


	@Column( name = "nombre", nullable = false, length = 512 )
	private String nombre;

	@Column( name = "direccion", nullable = true, length = 512)
	private String direccion;

}
