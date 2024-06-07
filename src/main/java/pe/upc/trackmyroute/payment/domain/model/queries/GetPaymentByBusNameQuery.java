package pe.upc.trackmyroute.payment.domain.model.queries;

import pe.upc.trackmyroute.payment.domain.model.valueobjects.Bus;

public record GetPaymentByBusNameQuery(Bus busName) {
}
