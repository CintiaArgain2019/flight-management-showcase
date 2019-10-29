package org.cargain.flight.management.controller;

import java.util.List;

import org.cargain.flight.management.model.Flight;
import org.cargain.flight.management.model.FlightSearch;
import org.cargain.flight.management.service.FlightService;
import org.cargain.flight.management.utils.ResourcesConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller for managing Flights.
 * 
 * @author Cintia Argain
 *
 */
@RequestMapping(value = ResourcesConstants.ENTITY + ResourcesConstants.API + ResourcesConstants.VERSION)
@Api(value = "Flight Management Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"Flight Management" })
@RestController
@Slf4j
public class FlightController {

	private final FlightService flightService;

	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	/**
	 * GET / : Retrieve all Flights.
	 * 
	 * @return the ResponseEntity with status 200 (OK) and with body all Flights.
	 * @throws FlightNotFoundException 204 (No Content) if the database is empty.
	 */
	@ApiOperation(value = "View a list of flight", notes = "Provides an operation to return all flights")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 204, message = "No content to show", response = String.class) })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> listAllCustomers() {
		log.info("Retrieving all flights");
		List<Flight> flights = flightService.findAll();
		if (flights.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);

	}

	/**
	 * GET /:flightId : get Flight by id.
	 *
	 * @param id the Flight's id to find
	 * @return the ResponseEntity with status 200 (OK) and with body the "id"
	 *         Flight,
	 * @throws FlightNotFoundException 404 (Not Found) if the Flight can not be
	 *                                 found.
	 */
	@ApiOperation(value = "Search a Flight with an ID", response = Flight.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved Flight", response = Flight.class),
			@ApiResponse(code = 204, message = "Flight not found", response = String.class) })

	@RequestMapping(value = "/{flightId}", method = RequestMethod.GET)
	public ResponseEntity<Flight> getFlight(@PathVariable("flightId") long flightId)  {
		log.info("Searching flight with Id: {}", flightId);
		
		Flight flight = flightService.findById(flightId);
		if (flight == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	}

	/**
	 * GET /:filter : get Flight by specified filter values.
	 *
	 * @param filter the Flight filter data
	 * @return the ResponseEntity with status 200 (OK) and with body all Flights
	 * 
	 */
	@ApiOperation(value = "Search a Flight with a filter", response = Flight.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved Flight", response = Flight.class),
			@ApiResponse(code = 204, message = "Flight not found", response = String.class) })

	@RequestMapping( value ="/search",method = RequestMethod.GET)
	public List<Flight> findAll(@RequestBody FlightSearch filter) {
		log.info("Retrieving flights matching filter: {}", filter.toString());
		return flightService.searchScheduled(filter);
	}

}
