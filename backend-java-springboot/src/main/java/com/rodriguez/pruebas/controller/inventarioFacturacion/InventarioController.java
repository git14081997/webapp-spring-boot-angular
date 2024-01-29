
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Inventario;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Producto;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase contiene los endpoint para consultar, crear o modificar recursos.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("api/inventario")
public class InventarioController {

	private static final Logger log = LoggerFactory.getLogger(InventarioController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private InventarioRepository inventarioRepository;

	@Autowired
	private ProductoRepository productoRepository;


	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Inventario> resultados encontrados.
	 */
	@Transactional
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/{idproducto}")
	public Page<Inventario> findAll(
		@PathVariable Integer pagina, @PathVariable Integer cantidad, @PathVariable Integer idproducto){


		Sort sort = Sort.by(Sort.Direction.DESC ,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);

		Producto producto = productoRepository.getReferenceById(idproducto);

		return inventarioRepository.findByProducto(pageable, producto);
	}



}
