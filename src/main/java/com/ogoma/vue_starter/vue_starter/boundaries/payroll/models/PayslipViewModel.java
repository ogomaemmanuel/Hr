package com.ogoma.vue_starter.vue_starter.boundaries.payroll.models;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollDeduction;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.enums.PayrollCalculation;
import com.ogoma.vue_starter.vue_starter.utils.numbers.EnglishNumberToWordsConverter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import static humanize.ICUHumanize.spellNumber;


public class PayslipViewModel {
    private final Employee employee;
    private final List<PayrollAddition> payrollAdditions;
    private final List<PayrollDeduction> payrollDeductions;
    private BigDecimal totalDeduction;
    private BigDecimal totalEarnings;
    private BigDecimal netSalary;

    public PayslipViewModel(Employee employee,
                            List<PayrollAddition> payrollAdditions,
                            List<PayrollDeduction> payrollDeductions) {
        this.employee = employee;
        this.payrollAdditions = payrollAdditions;
        this.payrollDeductions = payrollDeductions;
    }

    public Employee getEmployee() {
        return employee;
    }

    public BigDecimal getTotalDeduction() {
        BigDecimal totalDeductions = this.payrollDeductions.stream().map((x) -> {
            if (x.getCalculation() == PayrollCalculation.PERCENTAGE) {
                return (x.getAmount().multiply(employee.getSalaryAmount()))
                        .divide(BigDecimal.valueOf(100));
            }
            return x.getAmount();
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalDeductions;
    }

    public List<PayrollAddition> getPayrollAdditions() {
        return payrollAdditions;
    }

    public List<PayrollDeduction> getPayrollDeductions() {
        return payrollDeductions;
    }

    public BigDecimal getTotalEarnings() {
        BigDecimal totalAdditions = this.payrollAdditions.stream().map((x) -> {
            if (x.getCalculation() == PayrollCalculation.PERCENTAGE) {
                return (x.getAmount().multiply(employee.getSalaryAmount()))
                        .divide(BigDecimal.valueOf(100));
            }
            return x.getAmount();
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalAdditions.add(employee.getSalaryAmount());
    }

    public BigDecimal getNetSalary() {
        if (this.netSalary != null) {
            return netSalary;
        }
        return this.getTotalEarnings().subtract(this.getTotalDeduction());
    }

    public String netSalaryToWords() {
        EnglishNumberToWordsConverter englishNumberToWordsConverter = new EnglishNumberToWordsConverter();
        return englishNumberToWordsConverter.Convert(this.getNetSalary().longValue());
    }
}
