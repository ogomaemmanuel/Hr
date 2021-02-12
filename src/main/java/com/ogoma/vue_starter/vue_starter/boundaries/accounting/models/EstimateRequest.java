package com.ogoma.vue_starter.vue_starter.boundaries.accounting.models;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.EstimateItem;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Client;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EstimateRequest {
    private Long clientId;
    private Long projectId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date estimateDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date expiryDate;
    @Min(value = 0l)
    private BigDecimal amount;
    private String otherInformation;
    @Min(message = "Enter a valid percentage amount",value = 0)
    @Max(message = "Enter a valid percentage amount",value = 100)
    private double percentageDiscount;
    private Set<EstimateItem> items = new HashSet<>();
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Date getEstimateDate() {
        return estimateDate;
    }

    public void setEstimateDate(Date estimateDate) {
        this.estimateDate = estimateDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public void setOtherInformation(String otherInformation) {
        this.otherInformation = otherInformation;
    }

    public double getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(double percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public Set<EstimateItem> getItems() {
        return items;
    }

    public void setItems(Set<EstimateItem> items) {
        this.items = items;
    }
}
