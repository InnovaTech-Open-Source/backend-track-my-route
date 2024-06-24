package pe.upc.trackmyroute.payment.interfaces.rest;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.trackmyroute.payment.domain.model.queries.GetAllPaymentsQuery;
import pe.upc.trackmyroute.payment.domain.model.queries.GetPaymentByIdQuery;
import pe.upc.trackmyroute.payment.domain.services.PaymentCommandService;
import pe.upc.trackmyroute.payment.domain.services.PaymentQueryService;
import pe.upc.trackmyroute.payment.interfaces.rest.resources.CreatePaymentResource;
import pe.upc.trackmyroute.payment.interfaces.rest.resources.PaymentResource;
import pe.upc.trackmyroute.payment.interfaces.rest.transform.CreatePaymentCommandFromResourceAssembler;
import pe.upc.trackmyroute.payment.interfaces.rest.transform.PaymentResourceFromEntityAssembler;
import pe.upc.trackmyroute.trip.domain.services.TripQueryService;

import java.util.List;

/*
    PaymentController
    <p>
        This class is the entry point for all the REST endpoints related to the Payment Entity
    </p>
*/

@RestController
@RequestMapping(value = "/api/v1/payment")
@Tag( name = "Payments", description = "Payments Management Endpoints")
public class PaymentController {

    private final PaymentQueryService paymentQueryService;
    private final PaymentCommandService paymentCommandService;

    public PaymentController(PaymentQueryService paymentQueryService, PaymentCommandService paymentCommandService) {
        this.paymentQueryService = paymentQueryService;
        this.paymentCommandService = paymentCommandService;
    }

    @GetMapping
    public ResponseEntity<List<PaymentResource>> getAllPayment(){
        var getAllPaymentsQuery = new GetAllPaymentsQuery();
        var payments = paymentQueryService.handle(getAllPaymentsQuery);
        var paymentResource = payments.stream().map(PaymentResourceFromEntityAssembler::transformResourceFromEntity).toList();
        return ResponseEntity.ok(paymentResource);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResource> getPaymentById(@PathVariable Long paymentId) {
        var getPaymentByIdQuery = new GetPaymentByIdQuery(paymentId);
        var payment = paymentQueryService.handle(getPaymentByIdQuery);
        if (payment.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(PaymentResourceFromEntityAssembler.transformResourceFromEntity(payment.get()));
    }

    @PostMapping
    public ResponseEntity<PaymentResource> createPayment(@RequestBody CreatePaymentResource resource) {
        var createPaymentCommand = CreatePaymentCommandFromResourceAssembler.toCommandFromResource(resource);
        var payment = paymentCommandService.handle(createPaymentCommand);
        if(payment.isEmpty()) return ResponseEntity.badRequest().build();

        var paymentResource =  PaymentResourceFromEntityAssembler.transformResourceFromEntity(payment.get());
        return new ResponseEntity<PaymentResource>(paymentResource, HttpStatus.CREATED);
    }
}
