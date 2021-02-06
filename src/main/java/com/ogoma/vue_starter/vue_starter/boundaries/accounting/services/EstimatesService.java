package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.EstimatesRepository;
import org.springframework.stereotype.Service;

@Service
public class EstimatesService {
    private final EstimatesRepository estimatesRepository;
    public EstimatesService(EstimatesRepository estimatesRepository) {
        this.estimatesRepository = estimatesRepository;
    }
}
