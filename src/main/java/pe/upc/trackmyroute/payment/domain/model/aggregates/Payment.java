package pe.upc.trackmyroute.payment.domain.model.aggregates;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.ExtensionMethod;
import org.springframework.data.domain.AbstractAggregateRoot;
import pe.upc.trackmyroute.payment.domain.model.valueobjects.*;
import pe.upc.trackmyroute.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

@Entity
@Getter
@NoArgsConstructor
public class Payment extends AuditableAbstractAggregateRoot<Payment> {

    @Embedded
    private Bus bus;
    @Embedded
    private Destination destination;
    @Embedded
    private Origin origin;
    @Embedded
    private TicketAmount ticket;
    @Embedded
    private TimeTrip timeTrip;

    public String getFullDestinationCoordinate(){
        return destination.getFullDestinationCoordinate();
    }

    public String getFullOriginCoordinate(){
        return origin.getFullOriginCoordinate();
    }

    public String getFullTicketAmount(){
        return ticket.getFullTicketAmount();
    }

    public String getFullTimeTrip(){
        return timeTrip.getTimeTrip();
    }

    public String getFullBusName(){
        return bus.getFullBusName();
    }
}
