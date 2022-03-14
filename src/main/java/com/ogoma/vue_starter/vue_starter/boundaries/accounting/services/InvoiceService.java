package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Invoice;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.InvoicePagedDataRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.InvoiceRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests.InvoiceRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Page<Invoice> getInvoices(InvoicePagedDataRequest invoicePagedDataRequest) {
        Page<Invoice> invoices =
                this.invoiceRepository.findAll(invoicePagedDataRequest.getSpecification(), invoicePagedDataRequest.toPageable());
        return invoices;
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        Optional<Invoice> invoice = this.invoiceRepository.findById(id);
        return invoice;
    }

    public void removeInvoice(Long id) {
        this.invoiceRepository.deleteById(id);
    }

    public Invoice createInvoice(InvoiceRequest invoiceRequest) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(invoiceRequest.getInvoiceDate());
        invoice.setDueDate(invoiceRequest.getExpiryDate());
        invoice.setOtherInformation(invoiceRequest.getOtherInformation());
        invoice.setItems(invoiceRequest.getItems());
        this.invoiceRepository.save(invoice);
        return invoice;
    }
}
