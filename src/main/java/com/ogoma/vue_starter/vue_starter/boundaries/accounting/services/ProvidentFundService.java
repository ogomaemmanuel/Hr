package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.ProvidentFundRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvidentFundService {
    private final ProvidentFundRepository providentFundRepository;

    public ProvidentFundService(ProvidentFundRepository providentFundRepository) {
        this.providentFundRepository = providentFundRepository;
    }
}
