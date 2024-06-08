package pe.upc.trackmyroute.notification.domain.model.queries;

public record GetNotificationByIdQuery(Long id) {
    public GetNotificationByIdQuery {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (id < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
