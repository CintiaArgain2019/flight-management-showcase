package org.cargain.flight.passenger.service;

import java.util.List;

import org.cargain.flight.passenger.domain.Passenger;

/**
 * 
 * @author Cintia Argain
 *
 */
public interface IPassengerService {

	/**
	 * Get all existing passenger
	 * 
	 * @return
	 */
	List<Passenger> findAll();

	/**
	 * Get a specific passenger
	 * 
	 * @param passengerId
	 * @return
	 */
	Passenger findPassenger(Long passengerId);

}
