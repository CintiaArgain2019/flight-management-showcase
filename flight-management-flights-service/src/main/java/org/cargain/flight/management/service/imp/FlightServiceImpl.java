package org.cargain.flight.management.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.cargain.flight.management.model.Flight;
import org.cargain.flight.management.model.FlightSearch;
import org.cargain.flight.management.repository.FlightRepository;
import org.cargain.flight.management.service.FlightService;
import org.cargain.flight.management.utils.FlightSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 
 * @author Cintia Argain
 *
 */
@Service
public class FlightServiceImpl implements FlightService {
	private final FlightRepository flightRepository;

	@Autowired
	public FlightServiceImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	@Override
	public List<Flight> searchScheduled(@RequestBody FlightSearch search) {
		Assert.notNull(search, "search");
		return flightRepository.findAll(FlightSpecs.searchScheduled(search)).collect(Collectors.toList());
	}

	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	@Override
	public Flight findById(long flightId) {
		Assert.notNull(flightId, "flightId");
		return flightRepository.findById(flightId);
	}
}
