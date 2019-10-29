package org.cargain.flight.booking.dto;

import java.io.Serializable;
import java.util.Date;

import org.cargain.flight.feign.response.FlightResponse;
import org.cargain.flight.feign.response.PassengerResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Cintia Argain
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class BookingResponseDTO implements Serializable {

    private static final long serialVersionUID = -5502910005749994943L;

    private Long bookingId;
    private Date departure;
    private Date arrival;
    private PassengerResponse passenger;
    private FlightResponse flight;

}
