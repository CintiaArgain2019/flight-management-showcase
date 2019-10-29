package org.cargain.flight.booking.service.impl;

import java.util.List;
import java.util.Optional;

import org.cargain.flight.booking.domain.Booking;
import org.cargain.flight.booking.dto.BookingResponseDTO;
import org.cargain.flight.booking.repository.BookingRepository;
import org.cargain.flight.booking.service.IBookingService;
import org.cargain.flight.feign.client.FlightFeignClient;
import org.cargain.flight.feign.client.PassengerFeignClient;
import org.cargain.flight.feign.response.FlightResponse;
import org.cargain.flight.feign.response.PassengerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Cintia Argain
 */
@Service
@Slf4j
public class BookingServiceImpl implements IBookingService {

	private final BookingRepository bookingRepository;

	@Autowired
	private FlightFeignClient flightFeignClient;

	@Autowired
	private PassengerFeignClient passengerFeignClient;

	@Autowired
	public BookingServiceImpl(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	/**
	 * Get all existing bookings just only for FeignClients
	 *
	 * @return all existing bookings
	 */
	@Override
	public List<Booking> findAll() {
		List<Booking> lit = bookingRepository.findAll();
		return lit;

	}

	/**
	 * Method to get all flight bookings for the passenger
	 *
	 * @param passengerId gets passenger ID
	 * @return extended flight booking DTO
	 */
	@Override
	public List<Booking> findAllForPassenger(Long passengerId) {

		return bookingRepository.findAllForPassenger(passengerId);

	}

	/**
	 * Method to save booking for passenger
	 *
	 * @param request to make booking
	 * @return flight booking DTO as a response
	 */
	@Override
	public Booking saveBooking(Booking request) {
		Booking savedBooking = null;
		Long flightId = request.getFlightId();

		FlightResponse response = flightFeignClient.getFligth(flightId);

		PassengerResponse passengerResponse = passengerFeignClient.getPassenger(request.getFlightId());
		log.debug("###### Passenger Found: {}", passengerResponse.toString());

		if (response == null) {
			System.out.println();
		} else {
			Booking booking = Booking.builder().departure(request.getDeparture()).arrival(request.getArrival())
					.passengerId(request.getPassengerId()).flightId(response.getId()).build();

			log.debug("###### SAVING BOOKING #############");
			savedBooking = bookingRepository.save(booking);
			log.debug("### SAVED BOOKING: {}", savedBooking.toString());
		}
		return savedBooking;
	}

	/**
	 * Update booking details
	 *
	 * @param request Payload with all the necessary data
	 * @return patched booking
	 */
	@Override
	public Booking updateBooking(Booking request) {
		Long bookingId = request.getId();

		Optional<Booking> booking = bookingRepository.findById(bookingId);
		if (booking.isPresent()) {
			Booking savedBooking = bookingRepository.save(request);
			return savedBooking;
		} else {
			return null;
		}

	}

	@Override
	public BookingResponseDTO findBookingFullInfo(Long bookingId) {
		BookingResponseDTO response = new BookingResponseDTO();
		Optional<Booking> booking = bookingRepository.findById(bookingId);
		if (booking.isPresent()) {
			FlightResponse flightResponse = flightFeignClient.getFligth(booking.get().getFlightId());
			response.setFlight(flightResponse);
			log.debug("flight: {}", flightResponse.toString());
			PassengerResponse passengerResponse = passengerFeignClient.getPassenger(booking.get().getPassengerId());
			log.debug("Passenger: {}", passengerResponse.toString());

			response.setFlight(flightResponse);
			response.setPassenger(passengerResponse);
		}
		return response;
	}

}
