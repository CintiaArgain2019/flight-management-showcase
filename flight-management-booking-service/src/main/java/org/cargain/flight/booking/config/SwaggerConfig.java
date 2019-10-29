package org.cargain.flight.booking.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger UI configuration class. By default, access the API documentation on
 * http://localhost:9000/swagger-ui.html
 *
 * @author Cintia Argain
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket swaggerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.cargain.flight.booking.controller"))
				.paths(PathSelectors.regex("/.*")).build().pathMapping("/")
				.genericModelSubstitutes(ResponseEntity.class).useDefaultResponseMessages(false).apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Booking REST API", "Booking API.", "0.0.1",
				"Terms of service", new Contact("Cintia Argain", "www.google.com", "Cintia.Argain@softvision.com"),
				"License of API", "API license URL", Collections.emptyList());
	}
}