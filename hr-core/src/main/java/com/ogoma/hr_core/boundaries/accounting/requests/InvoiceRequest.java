package com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Invoice;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.InvoiceItem;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.models.EstimateRequest;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class InvoiceRequest {
    @NotNull(message = "Select a client")
    private Long clientId;
    private Long projectId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Invoice date is required")
    private Date invoiceDate;
    @NotNull(message = "Invoice expiry date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date expiryDate;
    @Min(value = 0l)
    private BigDecimal amount;
    private String otherInformation;
    @Min(message = "Enter a valid percentage amount", value = 0)
    @Max(message = "Enter a valid percentage amount", value = 100)
    private double percentageDiscount;
    @Valid
    @NotEmpty(message = "No ivoice item added")
    @JsonProperty("invoiceItems")
    private List<InvoiceItem> items;

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

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
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

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }
}
