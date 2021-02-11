package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Tax;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.TaxService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TaxController {
    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @RequestMapping(value = "api/taxes", method = RequestMethod.GET)
    public ResponseEntity<?> getTaxes(PagedDataRequest pagedDataRequest) {
        Page<Tax> taxes = this.taxService.getTaxes(pagedDataRequest);
        return ResponseEntity.ok(taxes);
    }
    @RequestMapping(value = "api/taxes/all", method = RequestMethod.GET)
    public ResponseEntity<?> getTaxes() {
        List<Tax> taxes = this.taxService.getAllTaxes();
        return ResponseEntity.ok(taxes);
    }

    @RequestMapping(value = "api/taxes/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getTaxById(@PathVariable Long id) {
        Optional<Tax> tax = this.taxService.getTaxeById(id);
        return ResponseEntity.of(tax);
    }

    @RequestMapping(value = "api/taxes", method = RequestMethod.POST)
    public ResponseEntity<?> createTax(@Valid @RequestBody Tax tax) {
        tax = this.taxService.createTax(tax);
        return ResponseEntity.ok(tax);
    }

    @RequestMapping(value = "api/taxes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTax(@PathVariable Long id, @Valid @RequestBody Tax taxUpdateRequest) {
        Optional<Tax> tax = this.taxService.updateTax(id, taxUpdateRequest);
        return ResponseEntity.of(tax);
    }

    @RequestMapping(value = "api/taxes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeTax(@PathVariable Long id) {
        this.taxService.removeTax(id);
        return ResponseEntity.ok("tax successfully removed");
    }
}
