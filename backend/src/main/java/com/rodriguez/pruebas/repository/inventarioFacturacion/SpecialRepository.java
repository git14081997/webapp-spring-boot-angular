
package com.rodriguez.pruebas.repository.inventarioFacturacion;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpecialRepository {

	private static final Logger log = LoggerFactory.getLogger(SpecialRepository.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Getter @Setter
	private String sql;



}
