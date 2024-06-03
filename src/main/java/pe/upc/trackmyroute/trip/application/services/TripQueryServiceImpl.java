package pe.upc.trackmyroute.trip.application.services;

import org.springframework.stereotype.Service;
import pe.upc.trackmyroute.trip.domain.model.aggregates.Trip;
import pe.upc.trackmyroute.trip.domain.model.queries.GetTripByPriceQuery;
import pe.upc.trackmyroute.trip.domain.model.queries.GetTripByLocationQuery;
import pe.upc.trackmyroute.trip.domain.model.queries.GetTripByIdQuery;
import pe.upc.trackmyroute.trip.domain.services.TripQueryService;
import pe.upc.trackmyroute.trip.infrastructure.persistence.jpa.repositories.TripRepository;

import javax.management.Query;
import java.util.Optional;

@Service
public class TripQueryServiceImpl implements TripQueryService {

    private final TripRepository tripRepository;

    public TripQueryServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Optional<Trip> handle(GetTripByIdQuery query) {
        return tripRepository.findById(query.tripId());
    }

    @Override
    public Optional<Trip> handle(GetTripByPriceQuery query) {

        return tripRepository.findByPrice(query.price());
    }

    @Override
    public Optional<Trip> handle(GetTripByLocationQuery query) {
        return tripRepository.findByLocation(query.latitude(), query.longitude());
    }
}