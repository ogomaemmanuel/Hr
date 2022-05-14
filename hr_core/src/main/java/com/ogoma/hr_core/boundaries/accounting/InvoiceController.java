package com.ogoma.hr_core.boundaries.accounting;

import com.ogoma.hr_core.boundaries.accounting.entities.Invoice;
import com.ogoma.hr_core.boundaries.accounting.models.InvoicePagedDataRequest;
import com.ogoma.hr_core.boundaries.accounting.requests.InvoiceRequest;
import com.ogoma.hr_core.boundaries.accounting.services.InvoiceService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @RequestMapping(value = "api/invoices", method = RequestMethod.GET)
    public ResponseEntity<?> getInvoices(InvoicePagedDataRequest invoicePagedDataRequest) {
        Page<Invoice> invoicePage =
                this.invoiceService.getInvoices(invoicePagedDataRequest);
        return ResponseEntity.ok(invoicePage);
    }
    @RequestMapping(value = "api/invoices/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getInvoiceByID(@PathVariable("id") Long id) {
        Optional<Invoice> invoice =
                this.invoiceService.getInvoiceById(id);
        return ResponseEntity.of(invoice);
    }

    @RequestMapping(value = "api/invoices", method = RequestMethod.POST)
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        Invoice invoice = this.invoiceService.createInvoice(invoiceRequest);
        return ResponseEntity.ok(invoice);
    }

    @RequestMapping(value = "api/invoices/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeInvoice(@PathVariable Long id) {
        this.invoiceService.removeInvoice(id);
        return ResponseEntity.ok("Invoice successfully removed");
    }

}
