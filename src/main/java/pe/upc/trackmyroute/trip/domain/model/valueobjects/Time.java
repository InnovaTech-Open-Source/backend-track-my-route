package pe.upc.trackmyroute.trip.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.time.LocalTime;

@Embeddable
public record Time(
        LocalTime time
) {
    public Time() {
        this(null);
    }

    public Time {
        if (time == null) {
            throw new IllegalArgumentException("Time cannot be null");
        }
    }

    public Time(String timeString) {
        this(LocalTime.parse(timeString));
    }

    // Método para obtener el tiempo en un formato legible
    public String getTime() {
        return time.toString();
    }
}