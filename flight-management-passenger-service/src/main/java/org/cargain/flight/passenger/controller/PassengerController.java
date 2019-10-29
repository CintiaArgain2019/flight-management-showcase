package org.cargain.flight.passenger.controller;

import java.util.List;

import org.cargain.flight.passenger.domain.Passenger;
import org.cargain.flight.passenger.service.IPassengerService;
import org.cargain.flight.passenger.util.ResourcesConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller for managing passengers.
 * 
 * @author Cintia Argain
 *
 */
@RequestMapping(value = ResourcesConstants.ENTITY + ResourcesConstants.API + ResourcesConstants.VERSION)
@Api(value = "Passenger Management Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"Passenger Management" })
@RestController
@Slf4j
public class PassengerController {
	
	private final IPassengerService passengerService;

	@Autowired
	public PassengerController(IPassengerService passengerService) {
		this.passengerService = passengerService;
	}

	/**
	 * GET / : Retrieve all Passengers.
	 * 
	 * @return the ResponseEntity with status 200 (OK) and with body all Passengers.
	 *         204 (No Content) if the database is empty.
	 */
	@ApiOperation(value = "View a list of passengers", notes = "Provides an operation to return all passengers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 204, message = "No content to show", response = String.class) })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Passenger>> getAllPassengers() {
		log.info("Retrieving all passengers");
		List<Passenger> result = passengerService.findAll();

		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Passenger>>(result, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/{passengerId}")
	public ResponseEntity<Passenger> getPassenger(@PathVariable("passengerId") Long passengerId) {

		Passenger result = passengerService.findPassenger(passengerId);

		if (result == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Passenger>(result, HttpStatus.OK);
		}

	}
	
}
