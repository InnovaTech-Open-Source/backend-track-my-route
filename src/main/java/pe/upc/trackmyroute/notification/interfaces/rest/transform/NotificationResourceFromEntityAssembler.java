package pe.upc.trackmyroute.notification.interfaces.rest.transform;

import pe.upc.trackmyroute.notification.domain.model.entities.Notification;
import pe.upc.trackmyroute.notification.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
    public static NotificationResource transformResourceFromEntity(Notification entity){
        return new NotificationResource(entity.getId(),entity.getMensaje());
    }
}
