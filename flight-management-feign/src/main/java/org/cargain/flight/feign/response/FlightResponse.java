package org.cargain.flight.feign.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Cintia Argain
 *
 */
@Getter
@Setter
@ToString
public class FlightResponse implements Serializable {

    private static final long serialVersionUID = -5365925665500006894L;

    private Long id;

    private Double distance;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private BigDecimal price;

    private String place;

}
