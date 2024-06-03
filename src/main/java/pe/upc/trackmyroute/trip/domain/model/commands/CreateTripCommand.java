package pe.upc.trackmyroute.trip.domain.model.commands;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateTripCommand(
        @NotBlank String originLatitude,
        @NotBlank String originLongitude,
        @NotBlank String destinationLatitude,
        @NotBlank String destinationLongitude,
        BigDecimal price,
        @NotBlank String currency,
        String time
) {
}