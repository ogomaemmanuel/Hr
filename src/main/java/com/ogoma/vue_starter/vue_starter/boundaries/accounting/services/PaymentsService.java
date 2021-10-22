package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Payment;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.PaymentRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentsService {
    private final PaymentRepository paymentRepository;

    public PaymentsService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    public Page<Payment> getPayments(PagedDataRequest pagedDataRequest) {
        Page<Payment> payments =
                this.paymentRepository.findAll(pagedDataRequest.toPageable());
        return payments;
    }
    public Optional<Payment> getPaymentsById(Long id) {
        Optional<Payment> payment = this.paymentRepository.findById(id);
        return payment;
    }
}
