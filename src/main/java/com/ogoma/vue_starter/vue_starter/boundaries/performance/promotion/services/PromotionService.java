package com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Designation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.DesignationRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.entities.Promotion;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.entities.Promotion_;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.repository.PromotionsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.requests.PromotionRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionService {
    private final PromotionsRepository promotionsRepository;
    private final DesignationRepository designationRepository;
    private final EmployeeRepository employeeRepository;

    public PromotionService(PromotionsRepository promotionsRepository,
                            DesignationRepository designationRepository,
                            EmployeeRepository employeeRepository) {
        this.promotionsRepository = promotionsRepository;
        this.designationRepository = designationRepository;
        this.employeeRepository = employeeRepository;
    }

    public Optional<Promotion> updatePromotion(Long id, PromotionRequest promotionRequest) {
        Optional<Promotion> promotion = this.promotionsRepository.findById(id);
        promotion.ifPresent(promo -> {
            dtoToEntity(promo, promotionRequest);
        });
        return promotion;
    }

    public List<Promotion> getPromotionByEmployeeId(Long id) {
        List<Promotion> promotions = this.promotionsRepository.findAll(new Specification<Promotion>() {
            @Override
            public Predicate toPredicate(Root<Promotion> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(Promotion_.ID), id);
            }
        });
        return promotions;
    }

    public List<Promotion> getPromotions() {
        return this.promotionsRepository.findAll();
    }

    public Promotion createPromotion(PromotionRequest promotionRequest) {
        Promotion promotion = new Promotion();
        dtoToEntity(promotion, promotionRequest);
        this.promotionsRepository.save(promotion);
        return promotion;
    }

    private void dtoToEntity(Promotion promotion, PromotionRequest promotionRequest) {
        Designation promotionFrom =
                this.designationRepository.getOne(promotionRequest.getFromDesignationId());
        Employee employee = this.employeeRepository.getOne(promotionRequest.getEmployeeId());
        Designation promotionTo = this.designationRepository.getOne(promotionRequest.getToDesignationId());
        promotion.setPromotionDate(promotionRequest.getPromotionDate());
        promotion.setFrom(promotionFrom);
        promotion.setTo(promotionTo);
        promotion.setEmployee(employee);
    }
}
