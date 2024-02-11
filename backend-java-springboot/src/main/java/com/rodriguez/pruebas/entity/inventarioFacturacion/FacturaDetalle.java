
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
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table( name = "factura_detalle", schema = "inventario_facturacion", catalog = "inventario_facturacion")
public class FacturaDetalle implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "factura_id")
	private Factura factura;
	// factura.facturaId

	@Column(name = "cantidad_producto_vendido", nullable = false )
	private Integer cantidadProductoVendido;

	@Column(name = "precio_venta_por_producto", scale = 2, nullable = false )
	private BigDecimal precioVentaPorProducto;




	@Column(name = "subtotal_por_producto", scale = 2)
	private BigDecimal subtotalPorProducto; // cantidadProductoVendido * precioVentaPorProducto


	@Column(name = "iva_del_subtotal_por_producto", scale = 2)
	private BigDecimal ivaDelSubtotalPorProducto; //subtotalPorProducto * 0.12 or 0.05


	@Column(name = "costo_unidad", scale = 2)
	private BigDecimal costoUnidad;


	@Column(name = "costo_del_subtotal_por_producto", scale = 2)
	private BigDecimal costoDelSubtotalPorProducto; // costoUnidad * cantidadProductoVendido




	@Column(name = "ganancia_unidad", scale = 2)
	private BigDecimal gananciaUnidad;

	@Column(name = "ganancia_del_subtotal_por_producto", scale = 2)
	private BigDecimal gananciaDelSubtotalPorProducto; // gananciaUnidad * cantidadProductoVendido

	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@Column( name = "nombre_producto")
	private String nombreProducto;

}
