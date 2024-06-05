package pe.upc.trackmyroute.payment.interfaces.rest;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.trackmyroute.payment.domain.model.aggregates.Payment;
import pe.upc.trackmyroute.payment.domain.model.queries.GetPaymentByIdQuery;
import pe.upc.trackmyroute.payment.domain.services.PaymentQueryService;

/*
    PaymentController
    <p>
        This class is the entry point for all the REST endpoints related to the Payment Entity
    </p>
*/

@RestController
@RequestMapping(value = "/api/v1/payment")
public class PaymentController {

    private final PaymentQueryService paymentQueryService;

    public PaymentController(PaymentQueryService paymentQueryService) {
        this.paymentQueryService = paymentQueryService;
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        var getPaymentByIdQuery = new GetPaymentByIdQuery(paymentId);
        var payment = paymentQueryService.handle(getPaymentByIdQuery);
        if (payment.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(payment.get());
    }
}
