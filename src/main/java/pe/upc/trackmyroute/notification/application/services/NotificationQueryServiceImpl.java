package pe.upc.trackmyroute.notification.application.services;

import org.springframework.stereotype.Service;
import pe.upc.trackmyroute.notification.domain.model.entities.Notification;
import pe.upc.trackmyroute.notification.domain.model.queries.GetNotificationByIdQuery;
import pe.upc.trackmyroute.notification.domain.model.queries.GetNotificationQuery;
import pe.upc.trackmyroute.notification.domain.services.NotificationQueryService;
import pe.upc.trackmyroute.notification.infraestructure.persistence.jpa.repositories.NotificationRepository;


import java.util.List;
import java.util.Optional;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {

    private final NotificationRepository notificationRepository;

    public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {

        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotification() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> handle(GetNotificationByIdQuery query) {
        return notificationRepository.findById(query.id());
    }



    @Override
    public List<Notification> handle(GetNotificationQuery query) {
        return notificationRepository.findAll();
    }
}
