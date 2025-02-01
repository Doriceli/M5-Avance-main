package com.proyect.avance.rest.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
			version = "v1",
			title = "Avance Proyecto", 
			description = "Construcción de un microservicio REST" 
					+ "por medio de los framework spring,"
					+ "spring-boot, spring data utilizando"
					+ "como mecanismo de persistencia MongoDB",
			contact = @Contact(
				name = "Doriceli Ixtla Montelongo", 
				url = "https://www.unam.mx/", 
			email = "doriceli.ixtla@gmail.com")))
public class OpenApiConfig {

}