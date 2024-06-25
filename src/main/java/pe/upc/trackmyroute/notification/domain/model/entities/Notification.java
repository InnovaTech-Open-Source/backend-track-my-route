package pe.upc.trackmyroute.notification.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.upc.trackmyroute.notification.domain.model.commands.CreateNotificationCommand;
import pe.upc.trackmyroute.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;

@Entity
@Table(name = "notificaciones")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends AuditableAbstractAggregateRoot<Notification> {

    private String mensaje;



}
