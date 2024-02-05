
package com.rodriguez.pruebas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiig {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.rodriguez.pruebas.controller"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(getApiInfo());
	} // api

	
	private ApiInfo getApiInfo(){
		return new ApiInfo(
		"Nombre del api rest",
		"Descripcion del api",
		"0.0.1",
		"Terminos del servicio",
		"Franklin Rodríguez",
		"https://www.com",
		"https://www.com"
		);
	} // getApiInfo

} // class
