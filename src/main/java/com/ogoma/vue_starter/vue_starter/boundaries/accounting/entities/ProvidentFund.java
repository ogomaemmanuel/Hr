package com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "provident_funds")
public class ProvidentFund {
    public enum ProvidentFundType {
        fixedAmount, percentOfBasic
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Description is required")
    private String description;
    @OneToOne
    private Employee employee;
    private BigDecimal employeeShare;
    private BigDecimal organisationShare;
    private BigDecimal percentageEmployeeShare;
    private BigDecimal percentageOrganisationShare;
    @Transient
    @JsonProperty
    private List<Map<ProvidentFundType,String>> providentFundTypesSelectList;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Enumerated(EnumType.STRING)
    private ProvidentFundType providentFundType;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ProvidentFundType getProvidentFundType() {
        return providentFundType;
    }

    public void setProvidentFundType(ProvidentFundType providentFundType) {
        this.providentFundType = providentFundType;
    }

    public List<Map<ProvidentFundType, String>> getProvidentFundTypesSelectList() {
       return Arrays.stream(ProvidentFundType.values()).map(
                x -> {
                    HashMap<ProvidentFundType, String> hashMap = new HashMap<ProvidentFundType, String>();
                    if (x.equals(ProvidentFundType.fixedAmount)) {
                        hashMap.put(x, "Fixed Amount");
                        return hashMap;
                    }
                    hashMap.put(x, "Percentage of Basic Salary");
                    return hashMap;
                }
        ).collect(Collectors.toList());
    }
}
