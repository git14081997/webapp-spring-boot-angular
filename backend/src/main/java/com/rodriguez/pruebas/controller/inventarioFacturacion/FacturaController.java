
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.FacturaDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Factura;
import com.rodriguez.pruebas.entity.inventarioFacturacion.TipoPago;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.FacturaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.TipoPagoRepository;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	private TipoPagoRepository tipoPagoRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@ResponseBody
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody FacturaDto facturaDto ){
		Factura factura = MODEL_MAPPER.map(facturaDto, Factura.class);
		factura = facturaRepository.save(factura);
		return factura.getId();
	}


	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public Factura findById(@PathVariable Integer id){
		Optional<Factura> resultado = facturaRepository.findById(id);
		return resultado.orElse(null);
	}



	/*
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Artista> findAll(){
		return artistaService.findAll();
	}
	*/



	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Factura> resultados encontrados.
	 */
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
	public Page<Factura> findAll(@PathVariable Integer pagina, @PathVariable Integer cantidad){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return facturaRepository.findAll(pageable);
	}



	@ResponseBody
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		facturaRepository.deleteById(id);
	}




	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<Factura> resultados encontrados.
	 */
	@ResponseBody
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}/{usuarioId}")
	public Page<Factura> findByCliente(
	@PathVariable Integer pagina, @PathVariable Integer cantidad, @PathVariable Integer usuarioId){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return facturaRepository.findByCliente(pageable,usuarioId);
	}



	@ResponseBody
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer update(@RequestBody FacturaDto dto ){

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
					objetoTemp.setNombre(usuario.getNombre());
					objetoTemp.setApellido(usuario.getApellido());
					objetoTemp.setNit(usuario.getNit());
					objetoTemp.setDireccion(usuario.getDireccion());
				}

				objetoTemp.setFechaEmision(dto.getFechaEmision());
				objetoTemp.setGanancia(dto.getGanancia());
				objetoTemp.setIva(dto.getIva());
				objetoTemp.setPendienteDePago(dto.getPendienteDePago());
				objetoTemp.setTotal(dto.getTotal());

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
		}
	}



}
