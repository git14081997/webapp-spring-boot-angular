
package com.rodriguez.pruebas.config;

import com.rodriguez.pruebas.security.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Esta clase es necesaria para configurar un filtro
 * que hará que sea necesario el uso de tokens en cada petición,
 * que use el patron determinado, en este caso cualquier endpoint que
 * empiece con /auth será necesario que venga con tokens para poder funcionar.
 *
 * @author Franklin Rodriguez
 * @version 0.0.1
 */
@Configuration
public class FilterConfig {

	@Bean
	FilterRegistrationBean<JwtFilter> jwtFilter() {

		FilterRegistrationBean<JwtFilter> filter = new FilterRegistrationBean<>();
		filter.setFilter(new JwtFilter());
		filter.addUrlPatterns("/auth/*");
		return filter;

	}

}
