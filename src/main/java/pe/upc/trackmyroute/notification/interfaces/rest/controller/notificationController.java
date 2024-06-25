package pe.upc.trackmyroute.notification.interfaces.rest.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.trackmyroute.notification.domain.model.entities.Notification;
import pe.upc.trackmyroute.notification.domain.model.queries.GetNotificationByIdQuery;
import pe.upc.trackmyroute.notification.domain.model.queries.GetNotificationQuery;
import pe.upc.trackmyroute.notification.domain.services.NotificationCommandService;
import pe.upc.trackmyroute.notification.domain.services.NotificationQueryService;
import pe.upc.trackmyroute.notification.interfaces.rest.resources.CreateNotificationResource;
import pe.upc.trackmyroute.notification.interfaces.rest.resources.NotificationResource;
import pe.upc.trackmyroute.notification.interfaces.rest.transform.CreateNotificationCommandFromResourceAssembler;
import pe.upc.trackmyroute.notification.interfaces.rest.transform.NotificationResourceFromEntityAssembler;
import pe.upc.trackmyroute.promos.domain.model.entities.Promo;
import pe.upc.trackmyroute.promos.domain.model.queries.GetPromosQuery;
import pe.upc.trackmyroute.promos.domain.services.PromoQueryService;
import pe.upc.trackmyroute.trip.domain.model.queries.GetTripByIdQuery;
import pe.upc.trackmyroute.trip.interfaces.rest.resources.TripResource;
import pe.upc.trackmyroute.trip.interfaces.rest.transform.TripResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/notifications")
@Tag(name="notifications", description = "notifications Management Endpoints")

public class notificationController {
    private final NotificationQueryService notificationQueryService;

    private final NotificationCommandService notificationCommandService;

    public notificationController(NotificationQueryService notificationQueryService, NotificationCommandService notificationCommandService) {
        this.notificationQueryService = notificationQueryService;
        this.notificationCommandService = notificationCommandService;
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        var notifications = notificationQueryService.handle(new GetNotificationQuery());
        if (notifications.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(notifications);
    }

    @PostMapping
    public ResponseEntity<NotificationResource> createNotification(@RequestBody CreateNotificationResource resource){
        var createNotificationCommand = CreateNotificationCommandFromResourceAssembler.toCommandFromResource(resource);
        var notification = notificationCommandService.handle(createNotificationCommand);

        if(notification.isEmpty()) ResponseEntity.badRequest().build();

        var notificationResource = NotificationResourceFromEntityAssembler.transformResourceFromEntity(notification.get());

        return new ResponseEntity<NotificationResource>(notificationResource, HttpStatus.CREATED);
    }

}
