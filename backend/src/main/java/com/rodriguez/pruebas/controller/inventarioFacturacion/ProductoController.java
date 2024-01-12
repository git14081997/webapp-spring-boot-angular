
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Inventario;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.UpdateInventario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ImagenProductoRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.InventarioRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ProductoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;


/**
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("api/producto")
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private ImagenProductoRepository imagenProductoRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private InventarioRepository inventarioRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;



	@Transactional
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody Producto producto){

		/* Producto producto = MODEL_MAPPER.map(productoDto, Producto.class); */

		producto.setId(null);

		producto.setEstado("A"); // A Activo or I Inactivo

		BigDecimal costo = producto.getCostoUnidad();
		BigDecimal ganancia = producto.getGanancia();

		BigDecimal precioVenta =  costo.add(ganancia);

		producto.setPrecioVenta(precioVenta);
		// precio de venta Sin IVA
		// el IVA se pondrá al realizar/registrar venta/pedido

		producto.setFechaAdquisicion(new Date());

		producto = productoRepository.save(producto);


		Inventario inventario = new Inventario();

		inventario.setProducto(producto);

		inventario.setSaldoAnterior(0);

		inventario.setEntradas( producto.getExistencias() );

		inventario.setSalidas(0);

		inventario.setExistencia(
			inventario.getSaldoAnterior()
			+ inventario.getEntradas()
			- inventario.getSalidas()
		);
		inventarioRepository.save(inventario);

		return producto.getId();
	}




	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public Producto findById(@PathVariable Integer id){
		Optional<Producto> resultado = productoRepository.findById(id);
		return resultado.orElse(null);
	}


	/*
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> findAll(){
		return productoRepository.findAll();
	}
	*/


	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Producto> resultados encontrados.
	 */
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
	public Page<Producto> findAll(@PathVariable Integer pagina, @PathVariable Integer cantidad){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return productoRepository.findAll(pageable);
	}


	 /*
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		productoRepository.deleteById(id);
	}
	*/


	 
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Producto dto){

		/* Producto producto = MODEL_MAPPER.map(dto, Producto.class); */

		Integer tmpId = dto.getId();

		if(tmpId != null) {
			Optional<Producto> optional = productoRepository.findById(tmpId);
			if (optional.isPresent()) {
				Producto objetoDB = optional.get();

				BigDecimal costo = dto.getCostoUnidad();
				BigDecimal ganancia = dto.getGanancia();
				BigDecimal precioVenta =  costo.add(ganancia);

				objetoDB.setCostoUnidad(costo);

				objetoDB.setGanancia(ganancia);

				objetoDB.setPrecioVenta(precioVenta);

				objetoDB.setNombre( dto.getNombre() );

				objetoDB.setFechaModificado(new Date());

				productoRepository.save(objetoDB);
			}
		}
	}





	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Producto> resultados encontrados.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/buscar")
	public Page<Producto> findAllByNombre(
			@PathVariable Integer pagina, @PathVariable Integer cantidad,
			@RequestParam(required = true) String nombre){

		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		Page<Producto> resultado = productoRepository.findByNombreContainingIgnoreCase(pageable, nombre);

		/*
		resultado.forEach( resultadoN -> {
			resultadoN.setImagen(null);
		});
		*/
		return resultado;

	}












	/* guardar imagen del producto
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{idproducto}")
	public void updateImage(@RequestBody MultipartFile fileImagen, @PathVariable Integer idproducto) throws IOException {
		Optional<Producto> optional = productoRepository.findById(idproducto);
		if(optional.isEmpty()) {
			return;
		}
		Producto objetoTmp = optional.get();
		byte[] bytesImagen = fileImagen.getBytes();
		objetoTmp.setImagen(bytesImagen);
		productoRepository.save(objetoTmp);
	}
	*/




	/* regresar imagen del producto
	@GetMapping(produces = MediaType.IMAGE_PNG_VALUE, value = "pic/{idproducto}")
	public ResponseEntity<byte[]> updateImage(@PathVariable Integer idproducto) throws IOException {
		Optional<Producto> optional = productoRepository.findById(idproducto);
		if(optional.isEmpty()) {
			return null;
		}
		Producto objetoTmp = optional.get();
		byte[] image = objetoTmp.getImagen();

		return ResponseEntity.ok().contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body(image);
	}
	*/







	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "add")
	public void updateInventario(@RequestBody UpdateInventario dto){

		/* Producto producto = MODEL_MAPPER.map(dto, Producto.class); */

		Integer tmpId = dto.getIdProducto();

		if(tmpId != null) {

			Optional<Producto> optionalProducto = productoRepository.findById(tmpId);

			if (optionalProducto.isPresent()) {


				// Se aumenta el inventario del producto-1
				Producto productoDB = optionalProducto.get();
				Integer existenciasProducto = productoDB.getExistencias();
				Integer nuevoSaldoExistencias = existenciasProducto + dto.getEntradasProducto();
				productoDB.setExistencias( nuevoSaldoExistencias );
				productoRepository.save(productoDB);
				// Se aumenta el inventario del producto-2


				// Se aumenta el saldo en el inventario-1
				Inventario inventarioProducto = new Inventario();
				inventarioProducto.setProducto( productoDB );
				inventarioProducto.setSaldoAnterior( existenciasProducto );
				inventarioProducto.setEntradas( dto.getEntradasProducto() );
				inventarioProducto.setSalidas( 0 );
				inventarioProducto.setExistencia( nuevoSaldoExistencias );
				inventarioRepository.save(inventarioProducto);
				// Se aumenta el saldo en el inventario-2


			}


		}


	}


}
