package com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "employee_payroll_additions")
public class EmployeePayrollAddition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Amount is required")
    @Min(value = 0l,message = "Amount cannot less than zero")
    private BigDecimal amount;
    @NotNull(message = "Employee Id is required")
    @Column(name = "employee_id")
    private Long employeeId;
    @ManyToOne
    @JoinColumn(name = "employee_id",updatable = false,insertable = false)
    private Employee employee;

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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
