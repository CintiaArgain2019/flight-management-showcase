package org.cargain.flight.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @author Cintia Argain
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class FlightManagementFlightsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementFlightsServiceApplication.class, args);
	}

}
