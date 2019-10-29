package org.cargain.flight.management.utils;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import org.cargain.flight.management.model.Flight;
import org.cargain.flight.management.model.FlightSearch;
import org.cargain.flight.management.model.FlightStatus;
import org.springframework.data.jpa.domain.Specification;

/**
 * Specification for the flight
 * 
 * @author Cintia Argain
 *
 */
public class FlightSpecs {
	
	/**
	 * Filter by origin, destination and departure day
	 * 
	 * @param search search parameters
	 * @return spec
	 */
	public static Specification<Flight> searchScheduled(FlightSearch search) {
		return Specification.where(originEquals(search.getOrigin())).and(destinationEquals(search.getDestination()))
				.and(departureBetween(search.getDepartureFrom(), search.getDepartureTo()))
				.and(statusEquals(FlightStatus.SCHEDULED));
	}
	

	/**
	 * Filter by origin case insensitive.
	 * 
	 * @param origin example origin
	 * @return spec
	 */
	private static Specification<Flight> originEquals(String origin) {
		return (root, query, cb) -> equalIgnoreCase(cb, cb.upper(root.get("origin")), origin);
	}

	/**
	 * Filter by destination case insensitive.
	 * 
	 * @param destination example destination
	 * @return spec
	 */
	private static Specification<Flight> destinationEquals(String destination) {
		return (root, query, cb) -> equalIgnoreCase(cb, cb.upper(root.get("destination")), destination);
	}

	/**
	 * Filter flight from the range
	 * 
	 * @param from departure after specified date
	 * @param to   departure before specified date
	 * @return spec
	 */
	private static Specification<Flight> departureBetween(Date from, Date to) {
		return (root, query, cb) -> cb.and(cb.greaterThanOrEqualTo(root.get("departure"), from),
				cb.lessThan(root.get("departure"), to));
	}

	/**
	 * Find flights with specified status
	 * 
	 * @param status status to find
	 * @return spec
	 */
	private static Specification<Flight> statusEquals(FlightStatus status) {
		return (root, query, cb) -> cb.and(cb.equal(root.get("status"), status));
	}

	

	private static Predicate equalIgnoreCase(CriteriaBuilder cb, Expression<String> x, String y) {
		return cb.equal(x, y.toUpperCase());
	}
}
