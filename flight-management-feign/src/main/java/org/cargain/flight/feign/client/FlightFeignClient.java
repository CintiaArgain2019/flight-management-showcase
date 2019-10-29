package org.cargain.flight.feign.client;

import org.cargain.flight.feign.client.fallback.FlightServiceFeignClientFallbackFactory;
import org.cargain.flight.feign.response.FlightResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The value parameter will contain the service name to be looked up from
 * Eureka. If Eureka is not used then URL can be specified as well
 * 
 * @author cargain
 *
 */
@FeignClient(name = FlightFeignClient.SERVICE_ID, fallbackFactory = FlightServiceFeignClientFallbackFactory.class)
public interface FlightFeignClient {

	final String SERVICE_ID = "flight-management-flights-service";
	final String PAYMENT_PATH = "/flight/api/v1";

	@RequestMapping(method = RequestMethod.GET, value = PAYMENT_PATH + "/{flightId}")
	FlightResponse getFligth(@PathVariable("flightId") Long flightId);
}
