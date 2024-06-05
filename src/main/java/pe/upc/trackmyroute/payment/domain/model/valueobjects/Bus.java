package pe.upc.trackmyroute.payment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Bus(String busName) {
    public Bus() { this(null);}

    public Bus {
        if(busName == null || busName.isBlank()){
            throw new IllegalArgumentException("destination cannot be null");
        }
    }

    public String getFullBusName(){
        return String.format("%s", busName);
    }
}
