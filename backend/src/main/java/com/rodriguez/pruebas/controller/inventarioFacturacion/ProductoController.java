
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.ProductoDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Categoria;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
import com.rodriguez.pruebas.repository.inventarioFacturacion.CategoriaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ProductoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
@NoArgsConstructor
@RequestMapping("api/producto")
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody ProductoDto productoDto ){

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

		producto = productoRepository.save(producto);
		return producto.getId();
	}


	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public Producto findById(@PathVariable Integer id){
		Optional<Producto> resultado = productoRepository.findById(id);
		return resultado.orElse(null);
	}


	/*
	@ResponseBody
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
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
	public Page<Producto> findAll(@PathVariable Integer pagina, @PathVariable Integer cantidad){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return productoRepository.findAll(pageable);
	}


	@ResponseBody
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		productoRepository.deleteById(id);
	}


	@ResponseBody
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer update(@RequestBody ProductoDto dto ){

		Integer tmpId = dto.getId();

		if(tmpId == null){
			return -1;
		}
		else {

			Optional<Producto> optional = productoRepository.findById(tmpId);

			if( optional.isPresent() ){

				Producto objetoTmp = optional.get();

				objetoTmp.setNombre(dto.getNombre());

				objetoTmp.setExistencias(dto.getExistencias());
				objetoTmp.setCostoUnidad(dto.getCostoUnidad());

				objetoTmp.setGanancia(dto.getGanancia());
				objetoTmp.setGananciaPorcentaje(dto.getGananciaPorcentaje());

				objetoTmp.setIva(dto.getIva());
				objetoTmp.setPrecioVenta(dto.getPrecioVenta());

				objetoTmp.setAncho(dto.getAncho());
				objetoTmp.setColor(dto.getColor());

				objetoTmp.setEdad(dto.getEdad());
				objetoTmp.setGenero(dto.getGenero());

				objetoTmp.setTalla(dto.getTalla());
				objetoTmp.setFechaAdquisicion(dto.getFechaAdquisicion());

				Optional<Categoria> optionalCategoria =
				categoriaRepository.findById(dto.getCategoria().getId());

				if( optionalCategoria.isPresent() ){
					Categoria categoriaTmp = optionalCategoria.get();
					objetoTmp.setCategoria(categoriaTmp);
				}

				productoRepository.save(objetoTmp);
				return 0;
			}
			else {
				return -2;
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
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/buscar")
	public Page<Producto> findAllByNombre(
			@PathVariable Integer pagina, @PathVariable Integer cantidad,
			@RequestParam(required = true) String nombre){

		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		return productoRepository.findByNombreContainingIgnoreCase(pageable, nombre);
	}



}
