package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentsService {
    private final PaymentRepository paymentRepository;
    public PaymentsService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
}
