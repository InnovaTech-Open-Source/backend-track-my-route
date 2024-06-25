package pe.upc.trackmyroute.notification.application.services;

import org.springframework.stereotype.Service;
import pe.upc.trackmyroute.notification.domain.model.commands.CreateNotificationCommand;
import pe.upc.trackmyroute.notification.domain.model.entities.Notification;
import pe.upc.trackmyroute.notification.domain.services.NotificationCommandService;
import pe.upc.trackmyroute.notification.infraestructure.persistence.jpa.repositories.NotificationRepository;

import java.util.Optional;

@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {

    private final NotificationRepository notificationRepository;

    public NotificationCommandServiceImpl(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Optional<Notification> handle(CreateNotificationCommand command) {
        var notification = new Notification(command.mensaje());

        notificationRepository.save(notification);

        return Optional.of(notification);
    }
}
