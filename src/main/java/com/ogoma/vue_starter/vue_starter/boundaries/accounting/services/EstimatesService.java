package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.projections.EstimateProjection;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.EstimatesRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EstimatesService {
    private final EstimatesRepository estimatesRepository;

    public EstimatesService(EstimatesRepository estimatesRepository) {
        this.estimatesRepository = estimatesRepository;
    }

    public Page<EstimateProjection> getEstimates(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<EstimateProjection> estimates =
                this.estimatesRepository.getEstimates(pageRequest);
        return estimates;
    }
}
