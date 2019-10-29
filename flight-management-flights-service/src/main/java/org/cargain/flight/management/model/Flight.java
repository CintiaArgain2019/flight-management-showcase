package org.cargain.flight.management.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "FLIGHT")
@ToString
@Setter
@Getter
//Define a sequence - might also be in another class:
@SequenceGenerator(name="flight_seq", initialValue=1000, allocationSize=100)
public class Flight {
	@Id
	// Use the sequence that is defined above:
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="flight_seq")
	@Column(name = "flight_id", nullable = false)
	@ApiModelProperty(required = true, notes = "Id of the flight")
	private Long id;

    @Column(name = "origin", length=25)
	@ApiModelProperty(required = true, notes = "Origin of the flight")
    private String origin;

    @Column(name = "destination", length=25)
	@ApiModelProperty(required = true, notes = "Destination  of the flight")
    private String destination;

    @Column(name = "departure", length=25)
	@ApiModelProperty(required = true, notes = "Date of departure  of the flight")
    private Date departure;

    @Column(name = "arrival", length=25)
	@ApiModelProperty(required = true, notes = "Date of arrival  of the flight")
    private Date arrival;

    @Column(name = "flight_Number", length=25)
	@ApiModelProperty(required = true, notes = "Flight Number")
    private String flightNumber;

    @Column(name = "price", length=25)
	@ApiModelProperty(required = true, notes = "Price")
    private BigDecimal price;

    @ApiModelProperty(required = true, notes = "Status of the flight")
    @Enumerated(EnumType.STRING)
    private FlightStatus status;

}
