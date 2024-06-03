package pe.upc.trackmyroute.trip.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.upc.trackmyroute.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import pe.upc.trackmyroute.trip.domain.model.commands.CreateTripCommand;
import pe.upc.trackmyroute.trip.domain.model.valueobjects.Location;
import pe.upc.trackmyroute.trip.domain.model.valueobjects.Price;
import pe.upc.trackmyroute.trip.domain.model.valueobjects.Time;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Trip extends AuditableAbstractAggregateRoot<Trip> {

    @Embedded
    Location origin;

    @Embedded
    Location destination;

    @Embedded
    Price price;

    @Embedded
    Time arrivalTime;


    public Trip(CreateTripCommand command) {
        this.price = new Price(command.price(), command.currency());
        this.origin = new Location(command.originLatitude(), command.originLongitude());
        this.destination = new Location(command.destinationLatitude(), command.destinationLongitude());
        this.arrivalTime = new Time(command.time());
    }

    public String getOriginCoordinates() {
        return origin.getCoordinates();
    }

    public String getDestinationCoordinates() {
        return destination.getCoordinates();
    }

    public String getPrice() {
        return price.amount().toString();
    }


    public String getArrivalTime() {
        return arrivalTime.getTime();
    }


}