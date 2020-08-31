package com.ogoma.vue_starter.vue_starter.boundaries.payroll.models;

import java.math.BigDecimal;
import java.util.Date;

public interface EmployeeSalaryViewModel {
    public Long getId();
    public String getEmail();
    public Date joiningDate();
    public BigDecimal salaryAmount();
    public String getRole();
    public String getRoleId();
}
