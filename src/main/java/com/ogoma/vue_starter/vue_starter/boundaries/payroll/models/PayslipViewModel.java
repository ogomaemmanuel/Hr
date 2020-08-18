package com.ogoma.vue_starter.vue_starter.boundaries.payroll.models;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollDeduction;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.enums.PayrollCalculation;

import java.math.BigDecimal;
import java.util.List;

public class PayslipViewModel {
    private Employee employee;
    private List<PayrollAddition> payrollAdditions;
    private List<PayrollDeduction> payrollDeductions;
    private BigDecimal totalDeduction;
    private BigDecimal totalEarnings;
    private BigDecimal netSalary;

    public BigDecimal getTotalDeduction() {
        BigDecimal totalDeductions = this.payrollDeductions.stream().map((x) -> {
            if (x.getCalculation() == PayrollCalculation.PERCENTAGE) {
                return (x.getAmount().multiply(employee.getSalaryAmount())).divide(BigDecimal.valueOf(100));
            }
            return x.getAmount();
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalDeductions;
    }

    public BigDecimal getTotalEarnings() {
        BigDecimal totalAdditions = this.payrollAdditions.stream().map((x) -> {
            if (x.getCalculation() == PayrollCalculation.PERCENTAGE) {
                return (x.getAmount().multiply(employee.getSalaryAmount())).divide(BigDecimal.valueOf(100));
            }
            return x.getAmount();
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalAdditions.add(employee.getSalaryAmount());
    }
    public BigDecimal getNetSalary() {
        return this.getTotalEarnings().subtract(this.getTotalDeduction());
    }
}
