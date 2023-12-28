
package com.rodriguez.pruebas.dto.inventarioFacturacion;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Esta clase es una abstracción de la entidad Producto,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@Data
public class ProductoDto implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre;

	private String genero;
	private String edad;

	private String talla;
	private BigDecimal largo;

	private BigDecimal ancho;
	private String color;

	private Date fechaCreado;
	private Date fechaModificado;

	private Date fechaAdquisicion;
	private UsuarioDto usuarioModifico;

	private UsuarioDto usuarioCreo;
	private String estado;

	private BigDecimal costoUnidad;
	private BigDecimal gananciaPorcentaje;

	private BigDecimal ganancia;
	private BigDecimal iva;

	private BigDecimal precioVenta;
	private Integer existencias;

	private CategoriaDto categoria;
}
