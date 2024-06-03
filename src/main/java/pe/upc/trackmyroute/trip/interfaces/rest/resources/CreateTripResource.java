package pe.upc.trackmyroute.trip.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateTripResource(
         String originLatitude,
         String originLongitude,
         String destinationLatitude,
         String destinationLongitude,
         BigDecimal price,
         String currency,
         String time
) {
}