package com.ogoma.vue_starter.vue_starter.boundaries.payroll.models;

import java.math.BigDecimal;
import java.util.Date;

public interface EmployeeSalaryViewModel {
    public Long getId();
    public String getEmail();
    public Date getJoiningDate();
    public String getPhone();
    public BigDecimal getSalaryAmount();
    public String getDesignation();
    public String getRoleId();
    public String getFirstName();
    public String getDepartmentName();

    public String getLastName();

    default String getFullName() {
        String lastName = null;
        if (null != getLastName()) {
            lastName = getLastName();
        }
        if (null != getFirstName()) {
            return getFirstName().concat(" ").concat(lastName);
        }
        return "";
    }
}
