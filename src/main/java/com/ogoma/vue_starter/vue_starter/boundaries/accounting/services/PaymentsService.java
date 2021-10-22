package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Invoice;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Payment;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.InvoiceRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.PaymentRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests.PaymentRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentsService {
    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;

    public PaymentsService(PaymentRepository paymentRepository,
                           InvoiceRepository invoiceRepository) {
        this.paymentRepository = paymentRepository;
        this.invoiceRepository = invoiceRepository;
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
    public Payment createPayment(PaymentRequest paymentRequest) {
        Invoice invoice =
                invoiceRepository.getOne(paymentRequest.getInvoiceId());
        Payment payment = new Payment();
        payment.setPaymentDate(paymentRequest.getPaymentDate());
        payment.setNotes(paymentRequest.getNotes());
        payment.setAmount(paymentRequest.getAmount());
        payment.setInvoice(invoice);
        payment.setPaymentTypes(paymentRequest.getPaymentType());
        this.paymentRepository.save(payment);
        return payment;
    }
}
