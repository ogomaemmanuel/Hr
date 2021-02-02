package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Tax;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.TaxRepository;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
    private final TaxRepository taxRepository;
    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }
    public Tax createTax(Tax tax) {
        Tax newTax = new Tax();
        tax.setName(tax.getName());
        tax.setPercentageAmount(tax.getPercentageAmount());
        this.taxRepository.save(newTax);
        return newTax;
    }
}

