package org.cargain.flight.booking.service;

import java.util.List;

import org.cargain.flight.booking.domain.Booking;
import org.cargain.flight.booking.dto.BookingResponseDTO;

public interface IBookingService {

	List<Booking> findAll();

	List<Booking> findAllForPassenger(Long passengerId);
	
	BookingResponseDTO findBookingFullInfo(Long bookingId);

	Booking saveBooking(Booking request);

	Booking updateBooking(Booking request);
}
