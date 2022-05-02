package com.ogoma.vue_starter.vue_starter.boundaries.accounting.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
public class EstimateRequest {
    @NotNull(message = "Select a client")
    private Long clientId;
    private Long projectId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Estimate date is required")
    private Date estimateDate;
    @NotNull(message = "Estimate expiry date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date expiryDate;
    @Min(value = 0l)
    private BigDecimal amount;
    private String otherInformation;
    @Min(message = "Enter a valid percentage amount", value = 0)
    @Max(message = "Enter a valid percentage amount", value = 100)
    private double percentageDiscount;
    @Valid
    @NotEmpty(message = "No estimate item added")
    @JsonProperty("estimateItems")
    private List<EstimateItem> items;

    private boolean saveAndSend;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public List<EstimateItem> getItems() {
        return items;
    }

    public void setItems(List<EstimateItem> items) {
        this.items = items;
    }

    public boolean isSaveAndSend() {
        return saveAndSend;
    }

    public void setSaveAndSend(boolean saveAndSend) {
        this.saveAndSend = saveAndSend;
    }

    public static class EstimateItem {
        @NotNull(message = "Name is required")
        private String name;
        @NotBlank(message = "Description is required")
        private String description;
        @NotNull(message = "Unit cost is required")
        private BigDecimal unitCost;
        @NotNull(message = "Quantity is required")
        @Min(value = 1, message = "Enter a right figure for quantity")
        @JsonProperty("qty")
        private Integer quantity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getUnitCost() {
            return unitCost;
        }

        public void setUnitCost(BigDecimal unitCost) {
            this.unitCost = unitCost;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
    }
}
