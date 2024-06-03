package pe.upc.trackmyroute.trip.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.trackmyroute.trip.domain.model.aggregates.Trip;

import javax.print.attribute.standard.Destination;
import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    Optional<Trip> findByPrice(BigDecimal price);

    Optional<Trip> findByLocation(String latitude, String longitude);
}