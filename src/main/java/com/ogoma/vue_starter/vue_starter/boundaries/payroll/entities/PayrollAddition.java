package com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payroll-items")
public class PayrollAddition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
