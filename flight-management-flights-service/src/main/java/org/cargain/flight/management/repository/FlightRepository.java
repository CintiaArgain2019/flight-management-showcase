package org.cargain.flight.management.repository;

import java.util.stream.Stream;

import org.cargain.flight.management.model.Flight;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Cintia Argain
 *
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

	Stream<Flight> findAll(Specification<Flight> specification);
	
	/**
     * Returns a Flight that has a specific Id.
     * 
     * @param id the id of the Flight to find
     * @return Flight
     */
	Flight findById(long id);
}
