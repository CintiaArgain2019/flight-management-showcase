package org.cargain.flight.booking.controller;

import java.util.List;

import org.cargain.flight.booking.domain.Booking;
import org.cargain.flight.booking.dto.BookingResponseDTO;
import org.cargain.flight.booking.service.IBookingService;
import org.cargain.flight.booking.utils.ResourcesConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller for managing booking.
 * 
 * @author Cintia Argain
 *
 */
@RequestMapping(value = ResourcesConstants.ENTITY + ResourcesConstants.API + ResourcesConstants.VERSION)
@Api(value = "Booking Management Controller", produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"Booking Management" })
@RestController
@Slf4j
public class BookingController {

	private final IBookingService bookingService;

	@Autowired
	public BookingController(IBookingService bookingService) {
		this.bookingService = bookingService;
	}

	/**
	 * GET / : Retrieve all Bookings.
	 * 
	 * @return the ResponseEntity with status 200 (OK) and with body all Bookings.
	 * @throws BookingNotFoundException 204 (No Content) if the database is empty.
	 */
	@ApiOperation(value = "View a list of bookings", notes = "Provides an operation to return all bookings")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 204, message = "No content to show", response = String.class) })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Booking>> getAllBookings() {
		log.info("Retrieving all bookings");
		List<Booking> result = bookingService.findAll();

		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Booking>>(result, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/{passengerId}")
	public ResponseEntity<List<Booking>> getAllBookingsForPassenger(@PathVariable("passengerId") Long passengerId) {

		List<Booking> result = bookingService.findAllForPassenger(passengerId);

		if (result.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Booking>>(result, HttpStatus.OK);
		}

	}


	@PostMapping(value = "/makeBooking")
	@HystrixCommand(fallbackMethod = "fallback_makeBooking", commandProperties = {
		      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
		   })
	public ResponseEntity<Booking> makeBooking(@RequestBody Booking request) {

		Booking result = bookingService.saveBooking(request);

		if (result == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Booking>(result, HttpStatus.OK);
		}

	}
	
	public ResponseEntity<Booking> fallback_makeBooking(@RequestBody Booking request) {
		log.error("There was a problem accesing the endpoint to make a booking");
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/full/{passengerId}")
	public ResponseEntity<BookingResponseDTO> getBookingInfo(@PathVariable("passengerId") Long passengerId) {

		BookingResponseDTO result = bookingService.findBookingFullInfo(passengerId);

		if (result == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<BookingResponseDTO>(result, HttpStatus.OK);
		}

	}
}
