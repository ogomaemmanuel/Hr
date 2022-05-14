package com.ogoma.hr_core.boundaries.accounting.services;

import com.ogoma.hr_core.boundaries.accounting.entities.Invoice;
import com.ogoma.hr_core.boundaries.accounting.entities.Payment;
import com.ogoma.hr_core.boundaries.accounting.repositories.InvoiceRepository;
import com.ogoma.hr_core.boundaries.accounting.repositories.PaymentRepository;
import com.ogoma.hr_core.boundaries.accounting.requests.PaymentRequest;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
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
