package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Tax;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.TaxRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Page<Tax> taxes =
                this.taxRepository.findAll(pagedDataRequest.toPageable());
        return taxes;
    }

    public Optional<Tax> getTaxeById(Long id) {
        Optional<Tax> tax =
                this.taxRepository.findById(id);
        return tax;
    }

    public Optional<Tax> updateTax(Long id, Tax taxUpdateRequest) {
        Optional<Tax> tax =
                this.taxRepository.findById(id);
        tax.ifPresent(x -> {
            x.setPercentageAmount(taxUpdateRequest.getPercentageAmount());
            x.setName(taxUpdateRequest.getName());
            this.taxRepository.save(x);
        });
        return tax;
    }

    public void removeTax(Long id) {
        this.taxRepository.deleteById(id);
    }

    public List<Tax> getAllTaxes() {
        return this.taxRepository.findAll();
    }
}

