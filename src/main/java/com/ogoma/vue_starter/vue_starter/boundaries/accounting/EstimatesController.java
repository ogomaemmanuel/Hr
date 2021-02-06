package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.EstimatesService;
import org.springframework.stereotype.Controller;

@Controller
public class EstimatesController {
    private final EstimatesService estimatesService;
    public EstimatesController(EstimatesService estimatesService) {
        this.estimatesService = estimatesService;
    }


}
