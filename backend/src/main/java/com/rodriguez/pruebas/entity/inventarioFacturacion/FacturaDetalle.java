
package com.rodriguez.pruebas.entity.inventarioFacturacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Esta clase es una abstracción de la entidad FacturaDetalle,
 * y almacenará la información que se desee.
 *
 * @Author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "FACTURA_DETALLE", schema = "INVENTARIO_FACTURACION", catalog = "INVENTARIO_FACTURACION")
public class FacturaDetalle implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "FACTURA_ID")
	private Factura factura;

	@Column(name = "CANTIDAD_PRODUCTO_VENDIDO")
	private Integer cantidadProductoVendido;

	@Column(name = "PRECIO_VENTA_POR_PRODUCTO", scale = 2)
	private BigDecimal precioVentaPorProducto;

	@Column(name = "SUBTOTAL_POR_PRODUCTO", scale = 2)
	private BigDecimal subtotalPorProducto;

	@Column(name = "IVA_DEL_SUBTOTAL_POR_PRODUCTO", scale = 2)
	private BigDecimal ivaDelSubtotalPorProducto;

	@Column(name = "COSTO_UNIDAD", scale = 2)
	private BigDecimal costoUnidad;

	@Column(name = "COSTO_DEL_SUBTOTAL_POR_PRODUCTO", scale = 2)
	private BigDecimal costoDelSubtotalPorProducto;

	@Column(name = "GANANCIA_DEL_SUBTOTAL_POR_PRODUCTO", scale = 2)
	private BigDecimal gananciaDelSubtotalPorProducto;

	@ManyToOne
	@JoinColumn(name = "PRODUCTO_ID")
	private Producto producto;

}
