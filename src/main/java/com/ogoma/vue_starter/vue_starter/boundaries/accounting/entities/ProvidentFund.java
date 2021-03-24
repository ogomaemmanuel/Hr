package com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
public class ProvidentFund {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Description is required")
    private String description;
    @OneToOne
    private Employee employee;
    private BigDecimal employeeShare;
    private BigDecimal organisationShare;
    private BigDecimal percentageEmployeeShare;
    private BigDecimal percentageOrganisationShare;

    public Long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigDecimal getEmployeeShare() {
        return employeeShare;
    }

    public void setEmployeeShare(BigDecimal employeeShare) {
        this.employeeShare = employeeShare;
    }

    public BigDecimal getOrganisationShare() {
        return organisationShare;
    }

    public void setOrganisationShare(BigDecimal organisationShare) {
        this.organisationShare = organisationShare;
    }

    public BigDecimal getPercentageEmployeeShare() {
        return percentageEmployeeShare;
    }

    public void setPercentageEmployeeShare(BigDecimal percentageEmployeeShare) {
        this.percentageEmployeeShare = percentageEmployeeShare;
    }

    public BigDecimal getPercentageOrganisationShare() {
        return percentageOrganisationShare;
    }

    public void setPercentageOrganisationShare(BigDecimal percentageOrganisationShare) {
        this.percentageOrganisationShare = percentageOrganisationShare;
    }
}
