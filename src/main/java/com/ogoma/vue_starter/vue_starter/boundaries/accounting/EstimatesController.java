package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Estimate;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.projections.EstimateProjection;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.EstimatesService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstimatesController {
    private final EstimatesService estimatesService;
    public EstimatesController(EstimatesService estimatesService) {
        this.estimatesService = estimatesService;
    }

    @RequestMapping(value = "api/estimates")
    public ResponseEntity<?> getEstimate(PagedDataRequest pagedDataRequest){
        Page<EstimateProjection>  estimates=
                this.estimatesService.getEstimates(pagedDataRequest);
        return ResponseEntity.ok(estimates);
    }

}
