package org.cargain.flight.management.service;

import java.util.List;

import org.cargain.flight.management.model.Flight;
import org.cargain.flight.management.model.FlightSearch;

/**
 * 
 * @author Cintia Argain
 *
 */
public interface FlightService {

	/**
	 * Find all  flights
	 * 
	 * @param search search parameters
	 * @return flights
	 */
	List<Flight> findAll();
	
	/**
	 * Search scheduled flights
	 * 
	 * @param search search parameters
	 * @return flights
	 */
	List<Flight> searchScheduled(FlightSearch search);

	/**
	 * Find a flight by flight id
	 * 
	 * @param flightId flight id
	 * @return flight
	 */
	Flight findById(long id);
}
