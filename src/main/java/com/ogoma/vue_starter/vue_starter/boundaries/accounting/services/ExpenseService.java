package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Expense;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.ExpensePagedDataRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.ExpenseRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Page<Expense> getExpenses(ExpensePagedDataRequest expensePagedDataRequest) {
     Page<Expense> expenses=
             this.expenseRepository.findAll(expensePagedDataRequest.toPageable());
     return  expenses;
    }
}
