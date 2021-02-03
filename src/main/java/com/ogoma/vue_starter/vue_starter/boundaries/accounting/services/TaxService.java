package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Tax;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.TaxRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
    private final TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    public Tax createTax(Tax tax) {
        Tax newTax = new Tax();
        newTax.setName(tax.getName());
        newTax.setPercentageAmount(tax.getPercentageAmount());
        this.taxRepository.save(newTax);
        return newTax;
    }
    public Page<Tax> getTaxes(PagedDataRequest pagedDataRequest) {
        Pageable pageable = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<Tax> taxes = this.taxRepository.findAll(pageable);
        return taxes;
    }
}

