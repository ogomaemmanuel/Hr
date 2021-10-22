package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Payment;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.PaymentsService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class PaymentController {
    private final PaymentsService paymentsService;
    public PaymentController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }
    @RequestMapping(value = "api/payments", method = RequestMethod.GET)
    public ResponseEntity<?> getPayments(PagedDataRequest pagedDataRequest){
        Page<Payment> payments = this.paymentsService.getPayments(pagedDataRequest);
        return ResponseEntity.ok(payments);
    }
   @RequestMapping(value = "api/payments/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getPaymentById(@PathVariable("id") Long id){
       Optional<Payment> payment=
               this.paymentsService.getPaymentsById(id);
       return ResponseEntity.of(payment);
   }

   

}
