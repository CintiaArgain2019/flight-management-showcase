package org.cargain.flight.booking.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Cintia Argain
 */
@Builder
@Getter
@Setter // Should be removed after business logic gonna be ready
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOOKING")
@SequenceGenerator(name="booking_id_seq", initialValue=1000, allocationSize=100)
public class Booking {

	@Id
	// Use the sequence that is defined above:
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="booking_id_seq")
	@Column(name = "booking_id", nullable = false)
	@ApiModelProperty(required = true, notes = "Id of the booking")
	private Long id;

	@Column(name = "departure")
	private Date departure;

	@Column(name = "arrival")
	private Date arrival;

	@Column(name = "passenger_id")
	private Long passengerId;

	@Column(name = "flight_id")
	private Long flightId;

}
