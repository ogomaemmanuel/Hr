package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Invoice;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.InvoicePagedDataRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.InvoiceRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests.InvoiceRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.ClientsRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final ClientsRepository clientsRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, ClientsRepository clientsRepository) {
        this.invoiceRepository = invoiceRepository;
        this.clientsRepository = clientsRepository;
    }

    public Page<Invoice> getInvoices(InvoicePagedDataRequest invoicePagedDataRequest) {
        Page<Invoice> invoices =
                this.invoiceRepository.findAll(invoicePagedDataRequest.getSpecification(), invoicePagedDataRequest.toPageable());
        return invoices;
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        Optional<Invoice> invoice = this.invoiceRepository.getInvoiceById(id);
        return invoice;
    }

    public void removeInvoice(Long id) {
        this.invoiceRepository.deleteById(id);
    }

    public Invoice createInvoice(InvoiceRequest invoiceRequest) {
        Client client= this.clientsRepository.getOne(invoiceRequest.getClientId());
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(invoiceRequest.getInvoiceDate());
        invoice.setDueDate(invoiceRequest.getExpiryDate());
        invoice.setOtherInformation(invoiceRequest.getOtherInformation());
        invoice.setItems(invoiceRequest.getItems());
        invoice.setClient(client);
        this.invoiceRepository.save(invoice);
        return invoice;
    }
    public Optional<Invoice> updateInvoice(Long id, InvoiceRequest invoiceRequest) {
     Optional<Invoice> invoice=
             this.invoiceRepository.findById(id);

     invoice.ifPresent(inv->{
         Client client= this.clientsRepository.getOne(invoiceRequest.getClientId());
         inv.setInvoiceDate(invoiceRequest.getInvoiceDate());
         inv.setDueDate(invoiceRequest.getExpiryDate());
         inv.setOtherInformation(invoiceRequest.getOtherInformation());
         inv.setItems(invoiceRequest.getItems());
         inv.setClient(client);
         invoiceRepository.save(inv);
     });
     return invoice;
    }
}
