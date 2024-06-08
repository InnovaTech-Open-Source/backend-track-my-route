package pe.upc.trackmyroute.notification.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.trackmyroute.notification.domain.model.entities.Notification;
import pe.upc.trackmyroute.trip.domain.model.aggregates.Trip;
import pe.upc.trackmyroute.trip.domain.model.commands.CreateTripCommand;

import java.util.Optional;

@Service
public interface NotificationCommandService {

    Optional<Notification> handle(Notification notification);
}
