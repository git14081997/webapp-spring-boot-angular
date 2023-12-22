
package com.rodriguez.pruebas.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(
			ServletRequest servletRequest,
			ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {


		TokenJwt tokenJwt = new TokenJwt();

		final HttpServletRequest request = (HttpServletRequest) servletRequest;
		final HttpServletResponse response = (HttpServletResponse) servletResponse;
		final String authHeader = request.getHeader("Authorization");

		if ("OPTIONS".equals(request.getMethod())) {

			response.setStatus(HttpServletResponse.SC_OK);
			filterChain.doFilter(request, response);

		} else {

			if (authHeader == null || !authHeader.startsWith("Bearer ")) {

				throw new ServletException("There is not an Authorization header");

			}
			else {

				final String token = authHeader.substring(7);
				Claims claims = tokenJwt.getAllClaimsFromToken(token);
				request.setAttribute("claims", claims);
				filterChain.doFilter(request, response);

			}

		}


	}

}
