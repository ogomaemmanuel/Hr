package com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.repository;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionsRepository extends BaseRepo<Promotion> {

}
