package pe.upc.trackmyroute.trip.interfaces.rest.transform;

import pe.upc.trackmyroute.trip.domain.model.commands.CreateTripCommand;
import pe.upc.trackmyroute.trip.interfaces.rest.resources.CreateTripResource;

import java.math.BigDecimal;

public class CreateTripCommandFromResourceAssembler {
    public static CreateTripCommand toCommandFromResource(CreateTripResource resource) {
        return new CreateTripCommand(
                resource.originLatitude(),
                resource.originLongitude(),
                resource.destinationLatitude(),
                resource.destinationLongitude(),
                resource.price(),
                resource.currency(),
                resource.time()
        );
    }
}