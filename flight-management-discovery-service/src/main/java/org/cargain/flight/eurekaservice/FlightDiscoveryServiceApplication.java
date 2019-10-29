package org.cargain.flight.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FlightDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightDiscoveryServiceApplication.class, args);
	}
}
