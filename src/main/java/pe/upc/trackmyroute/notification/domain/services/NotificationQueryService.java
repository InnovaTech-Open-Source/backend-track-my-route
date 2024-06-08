package pe.upc.trackmyroute.notification.domain.services;


import org.springframework.stereotype.Service;
import pe.upc.trackmyroute.notification.domain.model.entities.Notification;
import pe.upc.trackmyroute.notification.domain.model.queries.GetNotificationByIdQuery;
import pe.upc.trackmyroute.notification.domain.model.queries.GetNotificationQuery;
import pe.upc.trackmyroute.promos.domain.model.queries.GetPromoByIdQuery;


import java.util.List;
import java.util.Optional;

@Service
public interface NotificationQueryService {

    Optional<Notification> handle( GetNotificationByIdQuery query);
    List<Notification> handle(GetNotificationQuery query);
}
