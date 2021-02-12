package com.ogoma.vue_starter.vue_starter.boundaries.accounting.specifications;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Estimate;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Estimate_;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.EstimatePagedDataRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class EstimatesSpecification {

    public static Specification<Estimate> getEstimatesSpec(EstimatePagedDataRequest estimatePagedDataRequest) {
        return new Specification<Estimate>() {
            @Override
            public Predicate toPredicate(Root<Estimate> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (estimatePagedDataRequest.getStartDate() != null &&
                        estimatePagedDataRequest.getEndDate() != null) {
                    predicates.add(criteriaBuilder.between(root.get(Estimate_.estimateDate),
                            estimatePagedDataRequest.getStartDate(),
                            estimatePagedDataRequest.getEndDate()));
                }
                if (estimatePagedDataRequest.getStartDate() != null &&
                        estimatePagedDataRequest.getEndDate() == null) {
                    predicates.add(criteriaBuilder.between(root.get(Estimate_.estimateDate),
                            estimatePagedDataRequest.getStartDate(),
                            estimatePagedDataRequest.getStartDate()));
                }
                if (estimatePagedDataRequest.getStartDate() == null &&
                        estimatePagedDataRequest.getEndDate() != null) {
                    predicates.add(criteriaBuilder.between(root.get(Estimate_.estimateDate),
                            estimatePagedDataRequest.getEndDate(),
                            estimatePagedDataRequest.getEndDate()));
                }
                if (Long.TYPE != criteriaQuery.getResultType()) {
                    root.fetch(Estimate_.client, JoinType.LEFT);
                    if (estimatePagedDataRequest.getClientId() != null) {
                        predicates.add(criteriaBuilder.equal(root.get
                                (Estimate_.client), estimatePagedDataRequest.getClientId()));
                    }
                } else {
                    root.join(Estimate_.client, JoinType.LEFT);
                    predicates.add(criteriaBuilder.equal(root.get
                            (Estimate_.CLIENT), estimatePagedDataRequest.getClientId()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }


}
