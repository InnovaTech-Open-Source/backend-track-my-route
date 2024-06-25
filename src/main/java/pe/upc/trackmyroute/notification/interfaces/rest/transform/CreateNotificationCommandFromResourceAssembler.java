package pe.upc.trackmyroute.notification.interfaces.rest.transform;

import pe.upc.trackmyroute.notification.domain.model.commands.CreateNotificationCommand;
import pe.upc.trackmyroute.notification.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {

    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource){
        return new CreateNotificationCommand(resource.mensaje());
    }
}
