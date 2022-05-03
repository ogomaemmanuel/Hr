package com.ogoma.hr_core.boundaries.accounting.specifications;

import com.ogoma.hr_core.boundaries.accounting.entities.Invoice;
import com.ogoma.hr_core.boundaries.accounting.entities.Invoice_;
import com.ogoma.hr_core.boundaries.accounting.models.InvoicePagedDataRequest;
import com.ogoma.hr_core.boundaries.project_management.entities.Client_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.*;

public class InvoiceSpecification {
    public static Specification<Invoice> getInvoiceSpec(InvoicePagedDataRequest invoicePagedDataRequest) {
        return new Specification<Invoice>() {
            @Override
            public Predicate toPredicate(Root<Invoice> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (invoicePagedDataRequest.getStartDate() != null &&
                        invoicePagedDataRequest.getEndDate() != null) {
                    predicates.add(criteriaBuilder.between(root.get(Invoice_.invoiceDate),
                            invoicePagedDataRequest.getStartDate(),
                            invoicePagedDataRequest.getEndDate()));
                }
                if (invoicePagedDataRequest.getStartDate() != null &&
                        invoicePagedDataRequest.getEndDate() == null) {
                    predicates.add(criteriaBuilder.between(root.get(Invoice_.invoiceDate),
                            invoicePagedDataRequest.getStartDate(),
                            invoicePagedDataRequest.getStartDate()));
                }
                if (invoicePagedDataRequest.getStartDate() == null &&
                        invoicePagedDataRequest.getEndDate() != null) {
                    predicates.add(criteriaBuilder.between(root.get(Invoice_.invoiceDate),
                            invoicePagedDataRequest.getEndDate(),
                            invoicePagedDataRequest.getEndDate()));
                }
                if (Long.class != criteriaQuery.getResultType()) {
                    root.fetch(Invoice_.client, JoinType.LEFT)
                            .fetch(Client_.USER, JoinType.LEFT);

                    if (invoicePagedDataRequest.getClientId() != null) {
                        predicates.add(criteriaBuilder.equal(root.get
                                (Invoice_.client), invoicePagedDataRequest.getClientId()));
                    }
                } else {
                    // root.join(Estimate_.client, JoinType.LEFT);
//                    predicates.add(criteriaBuilder.equal(root.get
//                            (Estimate_.CLIENT), estimatePagedDataRequest.getClientId()));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
