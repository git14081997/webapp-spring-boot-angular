
package com.rodriguez.pruebas.repository.inventarioFacturacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpecialRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public SpecialRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	/*
	public Page<Factura> getFacturasDelCliente(Integer usuarioId,Integer pagina, In){
	}
	*/

}
