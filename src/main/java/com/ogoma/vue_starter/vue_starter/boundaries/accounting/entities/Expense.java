package com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.enums.ExpenseStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private String purchaseFrom;
    private Date purchaseDate;
    private BigDecimal amount;
    @OneToOne
    private User purchasedBy;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "expense")
    private Set<ExpenseAttachment> attachments;
    private Date updatedAt;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private ExpenseStatus status;
    public Long getId() {
        return id;
    }

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

    public Set<ExpenseAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<ExpenseAttachment> attachments) {
        this.attachments = attachments;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getPurchasedBy() {
        return purchasedBy;
    }

    public void setPurchasedBy(User purchasedBy) {
        this.purchasedBy = purchasedBy;
    }

    public ExpenseStatus getStatus() {
        return status;
    }

    public void setStatus(ExpenseStatus status) {
        this.status = status;
    }
}
