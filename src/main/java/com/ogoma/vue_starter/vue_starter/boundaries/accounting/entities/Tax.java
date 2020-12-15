package com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "taxes")
public class Tax {
    @Id
    private Long id;
    private String name;
    private BigDecimal percentageAmount;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPercentageAmount() {
        return percentageAmount;
    }

    public void setPercentageAmount(BigDecimal percentageAmount) {
        this.percentageAmount = percentageAmount;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(Date creationAt) {
        this.creationAt = creationAt;
    }
}
