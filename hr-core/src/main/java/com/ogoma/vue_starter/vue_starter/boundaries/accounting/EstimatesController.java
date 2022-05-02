package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Estimate;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.EstimatePagedDataRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.EstimateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.projections.EstimateProjection;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.EstimatesService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EstimatesController {
    private final EstimatesService estimatesService;

    public EstimatesController(EstimatesService estimatesService) {
        this.estimatesService = estimatesService;
    }

    @RequestMapping(value = "api/estimates", method = RequestMethod.GET)
    public ResponseEntity<?> getEstimate(EstimatePagedDataRequest pagedDataRequest) {
        Page<Estimate> estimates =
                this.estimatesService.getEstimates(pagedDataRequest);
        return ResponseEntity.ok(estimates);
    }

    @RequestMapping(value = "api/estimates/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEstimateById(@PathVariable Long id) {
        Optional<Estimate> estimate =
                this.estimatesService.getEstimateById(id);
        return ResponseEntity.of(estimate);
    }

    @RequestMapping(value = "api/estimates", method = RequestMethod.POST)
    public ResponseEntity<?> createEstimate(@Valid @RequestBody EstimateRequest estimateRequest) {
        Estimate estimate =
                this.estimatesService.createEstimate(estimateRequest);
        return ResponseEntity.ok(estimate);
    }

    @RequestMapping(value = "api/estimates/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEstimate(@PathVariable Long id,
                                            @Valid @RequestBody EstimateRequest estimateRequest) {
        Optional<Estimate> estimate =
                this.estimatesService.updateEstimate(id, estimateRequest);
        return ResponseEntity.of(estimate);
    }

    @RequestMapping(value = "api/estimates/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeEstimate(@PathVariable Long id) {
        this.estimatesService.removeEstimateById(id);
        return ResponseEntity.ok("Estimate successfully removed");
    }

}
