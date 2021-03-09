package com.ogoma.vue_starter.vue_starter.boundaries.accounting.requests;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.enums.ExpenseStatus;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class ExpenseRequest {
    @NotBlank(message = "Item mame is required")
    private String itemName;
    @NotBlank(message = "Purchase From is required")
    private String purchaseFrom;
    @NotNull(message = "Purchase date is required")
    private Date purchaseDate;
    @NotNull(message = "Expense amount is required")
    private BigDecimal amount;
    @NotNull(message = "Select Employee")
    private Long purchasedById;
    @Enumerated(EnumType.STRING)
    private ExpenseStatus status;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPurchaseFrom() {
        return purchaseFrom;
    }

    public void setPurchaseFrom(String purchaseFrom) {
        this.purchaseFrom = purchaseFrom;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getPurchasedById() {
        return purchasedById;
    }
    public void setPurchasedById(Long purchasedById) {
        this.purchasedById = purchasedById;
    }
    public ExpenseStatus getStatus() {
        return status;
    }

    public void setStatus(ExpenseStatus status) {
        this.status = status;
    }
}
