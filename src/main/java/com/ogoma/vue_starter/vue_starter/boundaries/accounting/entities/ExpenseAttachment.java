package com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities;

import javax.persistence.*;

@Entity
@Table(name = "expense_attachments")
public class ExpenseAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @ManyToOne
    private Expense expense;

    public Long getId() {
        return id;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }
}
