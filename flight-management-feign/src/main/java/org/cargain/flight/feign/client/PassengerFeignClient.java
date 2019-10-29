package org.cargain.flight.feign.client;

import org.cargain.flight.feign.response.PassengerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * @author Cintia Argain
 *
 */
@FeignClient("flight-management-passenger-service")
public interface PassengerFeignClient {

	 @GetMapping("/passenger/api/v1/{passengerId}")
	 PassengerResponse getPassenger(@PathVariable("passengerId") Long passengerId);
}
