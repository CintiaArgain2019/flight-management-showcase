package org.cargain.flight.passenger.service.impl;

import java.util.List;
import java.util.Optional;

import org.cargain.flight.passenger.domain.Passenger;
import org.cargain.flight.passenger.repository.PassengerRepository;
import org.cargain.flight.passenger.service.IPassengerService;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Cintia Argain
 *
 */
@Service
public class PassengerServiceImpl implements IPassengerService {

	private PassengerRepository passengerRepository;

	public PassengerServiceImpl(PassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}

	@Override
	public List<Passenger> findAll() {
		return passengerRepository.findAll();
	}

	@Override
	public Passenger findPassenger(Long passengerId) {
		Optional<Passenger> passenger =  passengerRepository.findById(passengerId);
		if (passenger.isPresent())
			return passenger.get();
		
		return null;
	}

}
