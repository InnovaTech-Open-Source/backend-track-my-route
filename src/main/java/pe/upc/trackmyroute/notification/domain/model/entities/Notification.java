package pe.upc.trackmyroute.notification.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pe.upc.trackmyroute.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "notificaciones")
@Setter
@Getter

public class Notification extends AuditableAbstractAggregateRoot<Notification> {

    private String mensaje;


}
