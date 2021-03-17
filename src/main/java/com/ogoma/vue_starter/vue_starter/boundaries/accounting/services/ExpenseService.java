package com.ogoma.vue_starter.vue_starter.boundaries.accounting.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.UsersRepository;
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
    private final UsersRepository usersRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UsersRepository usersRepository) {
        this.expenseRepository = expenseRepository;
        this.usersRepository = usersRepository;
    }

    public Page<Expense> getExpenses(ExpensePagedDataRequest expensePagedDataRequest) {
        Page<Expense> expenses =
                this.expenseRepository.findAll(
                        expensePagedDataRequest.getExpenseSpecification(),
                        expensePagedDataRequest.toPageable());
        return expenses;
    }

    public Expense createExpense(ExpenseRequest expenseRequest) {
        Expense expense = new Expense();
        User user =
                this.usersRepository.getOne(expenseRequest.getPurchasedById());
        expense.setAmount(expenseRequest.getAmount());
        expense.setItemName(expenseRequest.getItemName());
        expense.setPurchaseDate(expenseRequest.getPurchaseDate());
        expense.setPurchaseFrom(expenseRequest.getPurchaseFrom());
        expense.setStatus(expenseRequest.getStatus());
        expense.setPurchasedBy(user);
        // TODO add attachment url after uploading attachment to s3
        this.expenseRepository.save(expense);
        return expense;
    }

    public Optional<Expense> getExpenseById(Long id) {
        Optional<Expense> expense =
                this.expenseRepository.findById(id);
        return expense;
    }

    public Optional<Expense> updateExpense(Long id, ExpenseRequest expenseRequest) {
        User user =
                this.usersRepository.getOne(expenseRequest.getPurchasedById());
        Optional<Expense> expense =
                this.expenseRepository.findById(id);
        expense.ifPresent(e -> {
            e.setStatus(expenseRequest.getStatus());
            e.setAmount(expenseRequest.getAmount());
            e.setPurchaseDate(expenseRequest.getPurchaseDate());
            e.setPurchaseFrom(expenseRequest.getPurchaseFrom());
            e.setItemName(expenseRequest.getItemName());
            e.setPurchasedBy(user);
            // TODO add attachment url after uploading attachment to s3
            this.expenseRepository.save(e);
        });
        return expense;
    }
}
