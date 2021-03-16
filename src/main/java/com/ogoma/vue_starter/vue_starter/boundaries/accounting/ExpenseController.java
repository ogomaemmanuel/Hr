package com.ogoma.vue_starter.vue_starter.boundaries.accounting;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Expense;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.ExpensePagedDataRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests.ExpenseRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.services.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<?> getExpenses(ExpensePagedDataRequest expensePagedDataRequest) {
        Page<Expense> expenses =
                this.expenseService.getExpenses(expensePagedDataRequest);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getExpenseById(@PathVariable Long id){
        Optional<Expense>  expense=
                this.expenseService.getExpenseById(id);
        return ResponseEntity.of(expense);
    }

    @PostMapping
    public ResponseEntity<?> createExpense(@Valid ExpenseRequest expenseRequest) {
        Expense expense = this.expenseService.createExpense(expenseRequest);
        return ResponseEntity.ok(expense);
    }
}
