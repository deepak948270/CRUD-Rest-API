package com.restapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "Deepak Thapak",
						email = "ds948270@gmail.com",
						url = "https://github.com/deepak948270"
						
						),
				description = "RESTFULL API FOR PERFORMING CRUD OPERATIONS",
				title = "CRUD API-deepaksharma",
				version = "1.0",
				license = @License(
						name = "linkedin",
						url = "https://www.linkedin.com/in/deepak-sharma-29b913241/"
						),
				termsOfService = "terms of service"
			
				),
		servers = {
				@Server(
						description = "server url",
						url = "http://localhost:8080"
						)
		},
		security = {
				@SecurityRequirement(
						name = "thapak-auth"
						)
		}
		 
		
		)
		
		  @SecurityScheme(
		   name = "thapak-auth",
		  scheme = "basic",
		  type = SecuritySchemeType.HTTP, 
		  in = SecuritySchemeIn.HEADER 
		  )
public class OpenApiConfig {

}
