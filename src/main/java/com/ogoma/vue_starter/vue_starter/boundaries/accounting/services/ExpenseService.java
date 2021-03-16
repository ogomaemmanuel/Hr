package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Expense;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.ExpensePagedDataRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.repositories.ExpenseRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests.ExpenseRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }
    public Page<Expense> getExpenses(ExpensePagedDataRequest expensePagedDataRequest) {
        Page<Expense> expenses =
                this.expenseRepository.findAll(expensePagedDataRequest.toPageable());
        return expenses;
    }
    public Expense createExpense(ExpenseRequest expenseRequest) {
        Expense expense = new Expense();
        expense.setAmount(expenseRequest.getAmount());
        expense.setItemName(expenseRequest.getItemName());
        expense.setPurchaseDate(expenseRequest.getPurchaseDate());
        expense.setPurchaseFrom(expenseRequest.getPurchaseFrom());
        expense.setStatus(expenseRequest.getStatus());
        // TODO add attachment url after uploading attachment to s3
        this.expenseRepository.save(expense);
        return expense;
    }

    public Optional<Expense> getExpenseById(Long id) {
       Optional<Expense> expense=
               this.expenseRepository.findById(id);
       return expense;
    }
}
