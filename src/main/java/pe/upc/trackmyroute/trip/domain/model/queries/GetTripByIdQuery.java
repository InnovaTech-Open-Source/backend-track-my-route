package pe.upc.trackmyroute.trip.domain.model.queries;

public record GetTripByIdQuery(Long tripId) {
    public GetTripByIdQuery {
        if (tripId == null) {
            throw new IllegalArgumentException("Trip ID cannot be null");
        }
        if (tripId < 0) {
            throw new IllegalArgumentException("Trip ID cannot be negative");
        }
    }
}