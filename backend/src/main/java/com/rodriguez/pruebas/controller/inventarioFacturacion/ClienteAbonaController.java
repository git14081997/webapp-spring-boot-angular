
package com.rodriguez.pruebas.controller.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.ClienteAbonaDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.ClienteAbona;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
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
@RequestMapping("api/clienteabona")
public class ClienteAbonaController {

	private static final Logger log = LoggerFactory.getLogger(ClienteAbonaController.class);

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private ClienteAbonaRepository clienteAbonaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	 
	@PostMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer save(@RequestBody ClienteAbonaDto clienteAbonaDto ){
		ClienteAbona clienteAbona = MODEL_MAPPER.map(clienteAbonaDto, ClienteAbona.class);
		clienteAbona = clienteAbonaRepository.save(clienteAbona);
		return clienteAbona.getId();
	}


	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
	public ClienteAbona findById(@PathVariable Integer id){
		Optional<ClienteAbona> resultado = clienteAbonaRepository.findById(id);
		return resultado.orElse(null);
	}


	/*
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteAbona> findAll(){
		return clienteAbonaRepository.findAll();
	}
	*/


	/**
	 * Retorna un listado ordenado por id de manera ascendente de los objetos por pagina.
	 *
	 * @param pagina consultada.
	 * @param cantidad maxima por pagina.
	 * @return Page<ClienteAbona> resultados encontrados.
	 */
	 
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{pagina}/{cantidad}")
	public Page<ClienteAbona> findAll(@PathVariable Integer pagina, @PathVariable Integer cantidad){
		Sort sort = Sort.by(Sort.Direction.ASC,"id");
		Pageable pageable = PageRequest.of(pagina,cantidad,sort);
		return clienteAbonaRepository.findAll(pageable);
	}


/*
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id){
		clienteAbonaRepository.deleteById(id);
	}
 */



	 
	@PutMapping(  produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer update(@RequestBody ClienteAbonaDto dto ){

		Integer tmpId = dto.getId();

		if(tmpId == null){
			return -1;
		}
		else {

			Optional<ClienteAbona> dataOnDB = clienteAbonaRepository.findById(tmpId);

			if( dataOnDB.isPresent() ){
				ClienteAbona objetoTemp = dataOnDB.get();

				objetoTemp.setFecha(dto.getFecha());
				objetoTemp.setValor(dto.getValor());

				clienteAbonaRepository.save(objetoTemp);
				return 0;
			}
			else {
				return -2;
			}
		}
	}




}
