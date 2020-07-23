package com.ogoma.vue_starter.vue_starter.boundaries.payroll;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "payroll-formula-items")
public class PayrollFormulaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal from;
    private BigDecimal to;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private PayrollFormula payrollFormula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFrom() {
        return from;
    }

    public void setFrom(BigDecimal from) {
        this.from = from;
    }

    public BigDecimal getTo() {
        return to;
    }

    public void setTo(BigDecimal to) {
        this.to = to;
    }

    public PayrollFormula getPayrollFormula() {
        return payrollFormula;
    }

    public void setPayrollFormula(PayrollFormula payrollFormula) {
        this.payrollFormula = payrollFormula;
    }
}
