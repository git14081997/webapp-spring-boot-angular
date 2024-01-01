
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.entity.inventarioFacturacion.Factura;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.UsuarioRepository;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("api/factura")
public class FacturaController {

	private static final Logger log = LoggerFactory.getLogger(FacturaController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private FacturaRepository facturaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	 
	@PostMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody Factura factura ){
		//Factura factura = MODEL_MAPPER.map(facturaDto, Factura.class);
		factura = facturaRepository.save(factura);
		return factura.getId();
	}


	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public Factura findById(@PathVariable Integer id){
		Optional<Factura> resultado = facturaRepository.findById(id);
		return resultado.orElse(null);
	}



	/*
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Factura> findAll(){
		return facturaRepository.findAll();
	}
	*/



	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Factura> resultados encontrados.
	 */
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
	public Page<Factura> findAll(@PathVariable Integer pagina, @PathVariable Integer cantidad){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return facturaRepository.findAll(pageable);
	}



/*
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		facturaRepository.deleteById(id);
	}
*/




	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Factura> resultados encontrados.
	 */
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/{usuarioId}")
	public Page<Factura> findByCliente(
	@PathVariable Integer pagina, @PathVariable Integer cantidad, @PathVariable Integer usuarioId){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return facturaRepository.findByCliente(pageable,usuarioId);
	}



	 
	@PutMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Factura factura ){


		facturaRepository.save(factura);

		/*
		Integer tmpId = dto.getId();

		if(tmpId == null){
			return -1;
		}
		else {

			Optional<Factura> dataOnDB = facturaRepository.findById(tmpId);

			if( dataOnDB.isPresent() ){

				Factura objetoTemp = dataOnDB.get();
				Optional<Usuario> optionalCliente = usuarioRepository.findById(dto.getCliente().getId());

				if(optionalCliente.isPresent()){
					Usuario usuario = optionalCliente.get();
					objetoTemp.setCliente(usuario);
					objetoTemp.setNombreCompleto(usuario.getNombreCompleto());
					objetoTemp.setNit(usuario.getNit());
					objetoTemp.setDireccion(usuario.getDireccion());
				}

				objetoTemp.setFechaEmision(dto.getFechaEmision());
				objetoTemp.setGanancia(dto.getGanancia());
				objetoTemp.setIva(dto.getIva());
				objetoTemp.setPendienteDePago(dto.getPendienteDePago());
				objetoTemp.setTotal(dto.getTotal());

				// E Efectivo; C Credito; V Visto
				objetoTemp.setTipoPago(objetoTemp.getTipoPago());


				Optional<TipoPago> optional = tipoPagoRepository.findById(dto.getTipoPago().getId());
				if(optional.isPresent()){
					TipoPago tipoPago = optional.get();
					objetoTemp.setTipoPago(tipoPago);
				}


				facturaRepository.save(objetoTemp);
				return 0;
			}
			else {
				return -2;
			}
			*/
		}




}
