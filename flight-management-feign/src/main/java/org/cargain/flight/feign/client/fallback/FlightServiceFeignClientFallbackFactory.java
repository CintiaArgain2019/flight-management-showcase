package org.cargain.flight.feign.client.fallback;

import org.cargain.flight.feign.client.FlightFeignClient;
import org.cargain.flight.feign.response.FlightResponse;
import org.springframework.stereotype.Component;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author cargain
 *
 */
@Component
@Slf4j
public class FlightServiceFeignClientFallbackFactory implements FallbackFactory<FlightFeignClient> {

	@Override
	public FlightFeignClient create(Throwable cause) {
		return new FlightFeignClient() {
			@Override
			public FlightResponse getFligth(Long flightId) {
				log.error("#### Fallback; reason was: " + cause.toString());
				FlightResponse FlightResponse = new FlightResponse();
				if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
					// Treat the HTTP 404 status
				}

				return FlightResponse;
			}

		};
	}

}