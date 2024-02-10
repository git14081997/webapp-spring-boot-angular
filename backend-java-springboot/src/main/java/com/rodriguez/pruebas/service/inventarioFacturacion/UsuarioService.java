
package com.rodriguez.pruebas.service.inventarioFacturacion;

import com.rodriguez.pruebas.dto.inventarioFacturacion.UsuarioDto;
import com.rodriguez.pruebas.entity.inventarioFacturacion.ClienteAbona;
import com.rodriguez.pruebas.entity.inventarioFacturacion.Usuario;
import com.rodriguez.pruebas.repository.inventarioFacturacion.ClienteAbonaRepository;
import com.rodriguez.pruebas.repository.inventarioFacturacion.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class UsuarioService implements IUsuarioService {

	private final String ERROR_0 = "ERROR AL GUARDAR ";

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ClienteAbonaRepository clienteAbonaRepository;


	@Transactional
	@Override
	public Integer guardar(UsuarioDto dto)
	{

		BigDecimal cero = new BigDecimal(0);
		BigDecimal pendienteDePago = dto.getPendienteDePago();
		ClienteAbona clienteAbona = new ClienteAbona();

		if(dto.getNombreDos() == null)
		{
			dto.setNombreDos("");
		}

		if(dto.getApellido() == null)
		{
			dto.setApellido("");
		}

		if(dto.getApellidoDos() == null)
		{
			dto.setApellidoDos("");
		}

		if( pendienteDePago == null)
		{
			pendienteDePago = cero;
		}

		if( pendienteDePago.compareTo(cero) > 0 )
		{
			clienteAbona.setSaldoAnterior(pendienteDePago);
			dto.setPendienteDePago(pendienteDePago);
		}
		else
		{
			clienteAbona.setSaldoAnterior(cero);
			dto.setPendienteDePago(cero);
		}


		clienteAbona.setCargos(cero);
		clienteAbona.setAbonos(cero);


		BigDecimal saldoActual = new BigDecimal(0);
		saldoActual = saldoActual.add(clienteAbona.getCargos());
		saldoActual = saldoActual.subtract( clienteAbona.getAbonos() );
		clienteAbona.setSaldo( saldoActual );

		dto.setPendienteDePago( saldoActual );


		clienteAbona.setDetalles("Saldo inicial");
		clienteAbona.setFactura(null);

		Usuario usuarioNew = MODEL_MAPPER.map(dto, Usuario.class);

		usuarioNew.setNombreCompleto(
			dto.getNombre() + " " + dto.getNombreDos()
			+ " " + dto.getApellido() + " " + dto.getApellidoDos()
		);




		usuarioNew = usuarioRepository.save(usuarioNew);
		clienteAbona.setCliente( usuarioNew );
		clienteAbona = clienteAbonaRepository.save(clienteAbona);




		if( usuarioNew.getId() == null )
		{
			throw new RuntimeException( ERROR_0 + dto.getClass().getName() );
		}


		if( clienteAbona.getId() == null )
		{
			throw new RuntimeException( ERROR_0 + clienteAbona.getClass().getName() );
		}

		return usuarioNew.getId();
	}




} // class
