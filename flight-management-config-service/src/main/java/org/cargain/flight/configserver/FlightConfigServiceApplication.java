package org.cargain.flight.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class FlightConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightConfigServiceApplication.class, args);
	}
}
