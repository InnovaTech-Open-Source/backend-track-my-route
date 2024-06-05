package pe.upc.trackmyroute.payment.application.services;

import pe.upc.trackmyroute.payment.domain.model.aggregates.Payment;
import pe.upc.trackmyroute.payment.domain.model.queries.GetPaymentByBusNameQuery;
import pe.upc.trackmyroute.payment.domain.model.queries.GetPaymentByIdQuery;
import pe.upc.trackmyroute.payment.domain.model.queries.GetPaymentByTicketAmountQuery;
import pe.upc.trackmyroute.payment.domain.services.PaymentQueryService;
import pe.upc.trackmyroute.payment.infraestructure.persistence.jpa.repositories.PaymentRepository;

import java.util.Optional;

public class PaymentQueryServiceImpl implements PaymentQueryService {

    private final PaymentRepository paymentRepository;

    public PaymentQueryServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @Override
    public Optional<Payment> handle(GetPaymentByIdQuery query) {
        return paymentRepository.findById(query.id());
    }

    @Override
    public Optional<Payment> handle(GetPaymentByTicketAmountQuery query) {
        return paymentRepository.findByTicket(query.ticket());
    }

    @Override
    public Optional<Payment> handle(GetPaymentByBusNameQuery query) {
        return paymentRepository.findByBusName(query.busName());
    }
}
