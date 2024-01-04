
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ImagenProductoRepository;
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
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;


/**
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @Author Franklin Rodriguez
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
	private JdbcTemplate jdbcTemplate;



	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody Producto producto){

		/*

		Producto producto = MODEL_MAPPER.map(productoDto, Producto.class);

		// valores por defecto al crear
		if(producto.getCostoUnidad() == null) {
			producto.setCostoUnidad(new BigDecimal(0));
		}


		// valores por defecto al crear
		if(producto.getGanancia() == null) {
			producto.setGanancia(new BigDecimal(0));
		}


		// valores por defecto al crear
		if(producto.getGananciaPorcentaje() == null) {
			producto.setGananciaPorcentaje(new BigDecimal(0));
		}


		// valores por defecto al crear
		if(producto.getIva() == null) {
			producto.setIva(new BigDecimal(0));
		}


		// valores por defecto al crear
		if(producto.getPrecioVenta() == null) {
			producto.setPrecioVenta(new BigDecimal(0));
		}

		// valores por defecto al crear
		if(producto.getExistencias() == null) {
			producto.setExistencias(0);
		}

		// valores por defecto al crear
		if(producto.getEstado() == null) {
			producto.setEstado("A");
		}
		*/

		BigDecimal costo = producto.getCostoUnidad();
		BigDecimal ganancia = producto.getGanancia();
		BigDecimal precioVenta =  costo.add(ganancia);
		producto.setPrecioVenta(precioVenta);


		producto = productoRepository.save(producto);
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

		if(tmpId != null){
			Optional<Producto> optional = productoRepository.findById(tmpId);
			if (optional.isPresent()) {

				Producto objetoDB = optional.get();

				BigDecimal costo = dto.getCostoUnidad();
				BigDecimal ganancia = dto.getGanancia();
				BigDecimal iva = dto.getIva();

				BigDecimal precioVenta =  costo.add(ganancia).add(iva);
				objetoDB.setPrecioVenta(precioVenta);

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

		resultado.forEach( resultadoN -> {
			resultadoN.setImagen(null);
		});

		return resultado;
	}












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




}
