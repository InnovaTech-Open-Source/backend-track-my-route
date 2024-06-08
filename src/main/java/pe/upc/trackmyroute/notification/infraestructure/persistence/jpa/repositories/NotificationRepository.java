package pe.upc.trackmyroute.notification.infraestructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.trackmyroute.notification.domain.model.entities.Notification;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
