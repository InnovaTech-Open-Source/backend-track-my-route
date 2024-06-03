package pe.upc.trackmyroute.trip.domain.services;
import org.springframework.stereotype.Service;

import pe.upc.trackmyroute.trip.domain.model.aggregates.Trip;
import pe.upc.trackmyroute.trip.domain.model.queries.GetTripByIdQuery;
import pe.upc.trackmyroute.trip.domain.model.queries.GetTripByLocationQuery;
import pe.upc.trackmyroute.trip.domain.model.queries.GetTripByPriceQuery;
import java.util.Optional;

@Service
public interface TripQueryService {
    Optional<Trip> handle(GetTripByIdQuery query);
    Optional<Trip> handle(GetTripByPriceQuery query);
    Optional<Trip> handle(GetTripByLocationQuery query);
}