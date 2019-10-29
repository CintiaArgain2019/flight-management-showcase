package org.cargain.flight.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"org.cargain.flight"})
@EnableCircuitBreaker
@EnableHystrix
public class FlightManagementBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementBookingServiceApplication.class, args);
	}

}
