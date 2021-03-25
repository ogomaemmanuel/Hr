package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.ProvidentFund;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests.ProvidentFundRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.ProvidentFundService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/provident-funds")
public class ProvidentFundController {
    private final ProvidentFundService providentFundService;

    public ProvidentFundController(ProvidentFundService providentFundService) {
        this.providentFundService = providentFundService;
    }

    @GetMapping
    public ResponseEntity<?> getProvidentFunds(PagedDataRequest pagedDataRequest) {
        Page<ProvidentFund> providentFunds =
                this.providentFundService.getProvidentFunds(pagedDataRequest);
        return ResponseEntity.ok(providentFunds);
    }

    @PostMapping
    public ResponseEntity<?> createProvidentFund(@RequestBody @Valid ProvidentFundRequest providentFundRequest) {
        ProvidentFund providentFund =
                this.providentFundService.createProvidentFund(providentFundRequest);
        return ResponseEntity.ok(providentFund);
    }

    @PutMapping
    public ResponseEntity<?> updateProvidentFund(Long id,@RequestBody @Valid ProvidentFundRequest providentFundRequest){
        Optional<ProvidentFund> providentFund=
                this.providentFundService.updateProvidentFund(id,providentFundRequest);
        return ResponseEntity.of(providentFund);
    }
}
