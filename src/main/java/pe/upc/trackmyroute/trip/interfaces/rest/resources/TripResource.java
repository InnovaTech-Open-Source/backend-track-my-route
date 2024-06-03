package pe.upc.trackmyroute.trip.interfaces.rest.resources;

import java.math.BigDecimal;

public record TripResource(
        Long id,
        String price,
        String origin,
        String destination,
        String time
) {
}