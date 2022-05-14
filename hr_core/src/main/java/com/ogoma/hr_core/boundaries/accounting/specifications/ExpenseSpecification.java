package com.ogoma.hr_core.boundaries.accounting.specifications;

import com.ogoma.hr_core.boundaries.accounting.entities.Expense;
import com.ogoma.hr_core.boundaries.accounting.entities.Expense_;
import com.ogoma.hr_core.boundaries.accounting.models.ExpensePagedDataRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseSpecification {

    public static Specification<Expense> getExpenseSpecification(ExpensePagedDataRequest expensePagedDataRequest) {
        return new Specification<Expense>() {
            @Override
            public Predicate toPredicate(Root<Expense> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (Long.class != criteriaQuery.getResultType()) {
                    root.fetch(Expense_.PURCHASED_BY, JoinType.LEFT);
                } else {
                    root.join(Expense_.PURCHASED_BY, JoinType.LEFT);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
