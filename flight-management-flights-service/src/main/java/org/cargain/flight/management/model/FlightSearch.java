package org.cargain.flight.management.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Cintia Argain
 *
 */
@Setter
@Getter
@ToString
public class FlightSearch {
    private String origin;
    private String destination;
    private Date departureFrom;
    private Date departureTo;

}
