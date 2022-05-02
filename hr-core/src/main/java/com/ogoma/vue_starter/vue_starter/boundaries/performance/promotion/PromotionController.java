package com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.entities.Promotion;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.requests.PromotionRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.services.PromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/promotions")
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public ResponseEntity<?> getPromotions() {
        List<Promotion> promotions = this.promotionService.getPromotions();
        return ResponseEntity.ok(promotions);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getPromotionById(@PathVariable Long id) {
        Optional<Promotion> promotion = this.promotionService.getPromotionById(id);
        return ResponseEntity.of(promotion);
    }

    @PostMapping
    public ResponseEntity<?> createPromotion(@Valid @RequestBody PromotionRequest promotionRequest) {
        Promotion promotion = this.promotionService.createPromotion(promotionRequest);
        return ResponseEntity.ok(promotion);
    }

    @PutMapping
    public ResponseEntity<?> updatePromotion(Long id, @RequestBody @Valid PromotionRequest promotionRequest) {
        Optional<Promotion> promotion =
                this.promotionService.updatePromotion(id, promotionRequest);
        return ResponseEntity.of(promotion);
    }
}
