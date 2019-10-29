package org.cargain.flight.booking.repository;

import java.util.List;

import org.cargain.flight.booking.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Cintia Argain
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {


    /**
     * Find all bookings by passenger ID
     *
     * @param passengerId whose booking should be found
     * @return list of bookings
     */
    @Query("SELECT r FROM Booking r WHERE r.passengerId = :passengerId")
    List<Booking> findAllForPassenger(@Param("passengerId") Long passengerId);


}
