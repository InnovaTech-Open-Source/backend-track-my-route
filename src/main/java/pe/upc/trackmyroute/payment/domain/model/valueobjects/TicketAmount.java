package pe.upc.trackmyroute.payment.domain.model.valueobjects;

public record TicketAmount(String exchange, String price) {
    public TicketAmount(){this(null, null);}
    public TicketAmount{
        if(exchange == null || exchange.isBlank()){
            throw new IllegalArgumentException("exchange cannot be null or blank");
        }

        if(price == null || price.isBlank()){
            throw new IllegalArgumentException("price cannot be null or blank");
        }
    }

    public String getFullTicketAmount(){
        return String.format("%s %s", exchange, price);
    }
}
