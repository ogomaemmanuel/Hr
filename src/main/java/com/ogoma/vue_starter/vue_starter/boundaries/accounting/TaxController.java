package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Tax;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.TaxService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaxController {
    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @RequestMapping(value = "api/taxes", method = RequestMethod.POST)
    public ResponseEntity<?> createTax(@RequestBody Tax tax) {
        tax = this.taxService.createTax(tax);
        return ResponseEntity.ok(tax);
    }
}
