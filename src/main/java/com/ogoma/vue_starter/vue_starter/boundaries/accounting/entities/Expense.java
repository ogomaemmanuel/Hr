package com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User_;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.enums.ExpenseStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "expenses")
public class Expense {

    public enum PaymentMethods {
        Cash, Cheque
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private String purchaseFrom;
    private Date purchaseDate;
    private BigDecimal amount;
    @ManyToOne
    @JsonIgnoreProperties(value = {
            User_.EMPLOYEE,
            User_.USER_ROLES
    })
    private User purchasedBy;
    @Enumerated(EnumType.STRING)
    private PaymentMethods paidBy;
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = ExpenseAttachment_.EXPENSE)
    private Set<ExpenseAttachment> attachments;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
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

    public PaymentMethods getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(PaymentMethods paidBy) {
        this.paidBy = paidBy;
    }

    public ExpenseStatus getStatus() {
        return status;
    }

    public void setStatus(ExpenseStatus status) {
        this.status = status;
    }
}
