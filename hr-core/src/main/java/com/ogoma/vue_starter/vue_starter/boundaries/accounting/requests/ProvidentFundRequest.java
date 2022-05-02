package com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.ProvidentFund;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProvidentFundRequest {
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Select an employee")
    private Long employeeId;
    private BigDecimal employeeShare;
    private BigDecimal organisationShare;
    private BigDecimal percentageEmployeeShare;
    private BigDecimal percentageOrganisationShare;
    @Enumerated(EnumType.STRING)
    private ProvidentFund.ProvidentFundType providentFundType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public ProvidentFund.ProvidentFundType getProvidentFundType() {
        return providentFundType;
    }

    public void setProvidentFundType(ProvidentFund.ProvidentFundType providentFundType) {
        this.providentFundType = providentFundType;
    }
}
