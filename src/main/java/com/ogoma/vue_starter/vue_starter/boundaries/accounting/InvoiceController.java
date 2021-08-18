package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Invoice;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.InvoicePagedDataRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.InvoiceService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class InvoiceController {
    private final InvoiceService invoiceService;
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public ResponseEntity<?> getInvoices(InvoicePagedDataRequest invoicePagedDataRequest){
        Page<Invoice> invoicePage=
                this.invoiceService.getInvoices(invoicePagedDataRequest);
        return  ResponseEntity.ok(invoicePage);
    }

}
