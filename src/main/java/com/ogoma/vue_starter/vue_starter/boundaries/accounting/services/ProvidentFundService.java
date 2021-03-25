package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.ProvidentFund;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.ProvidentFundRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProvidentFundService {
    private final ProvidentFundRepository providentFundRepository;

    public ProvidentFundService(ProvidentFundRepository providentFundRepository) {
        this.providentFundRepository = providentFundRepository;
    }

    public Page<ProvidentFund> getProvidentFunds(PagedDataRequest pagedDataRequest) {
      Page<ProvidentFund> providentFunds=
              this.providentFundRepository.findAll(pagedDataRequest.toPageable());
      return providentFunds;
    }
}
