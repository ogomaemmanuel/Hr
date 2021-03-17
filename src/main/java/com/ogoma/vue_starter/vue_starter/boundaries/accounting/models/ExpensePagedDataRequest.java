package com.ogoma.vue_starter.vue_starter.boundaries.accounting.models;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Expense;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.specifications.ExpenseSpecification;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class ExpensePagedDataRequest extends PagedDataRequest {
    private Long purchaseBy;
    private Long paidBy;
    private Date purchaseStartDate;
    private Date purchaseEndDate;

    public Long getPurchaseBy() {
        return purchaseBy;
    }

    public void setPurchaseBy(Long purchaseBy) {
        this.purchaseBy = purchaseBy;
    }

    public Long getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(Long paidBy) {
        this.paidBy = paidBy;
    }

    public Date getPurchaseStartDate() {
        return purchaseStartDate;
    }

    public void setPurchaseStartDate(Date purchaseStartDate) {
        this.purchaseStartDate = purchaseStartDate;
    }

    public Date getPurchaseEndDate() {
        return purchaseEndDate;
    }

    public void setPurchaseEndDate(Date purchaseEndDate) {
        this.purchaseEndDate = purchaseEndDate;
    }
    public Specification<Expense> getExpenseSpecification(){
        return ExpenseSpecification.getExpenseSpecification(this);
    }
}

