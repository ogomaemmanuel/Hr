package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.ProvidentFundService;
import org.springframework.stereotype.Controller;

@Controller
public class ProvidentFundController {
    private final ProvidentFundService providentFundService;
    public ProvidentFundController(ProvidentFundService providentFundService) {
        this.providentFundService = providentFundService;
    }
}
