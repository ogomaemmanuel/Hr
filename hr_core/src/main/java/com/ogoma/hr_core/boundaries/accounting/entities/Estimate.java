package com.ogoma.hr_core.boundaries.accounting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.boundaries.project_management.entities.Client;
import com.ogoma.hr_core.boundaries.project_management.entities.Project;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "estimates", indexes = {
        @Index(name = "estimate_date_index",
                columnList = Estimate_.ESTIMATE_DATE),
        @Index(name = "expiry_date_index", columnList = Estimate_.EXPIRY_DATE)
})
@EntityListeners(AuditingEntityListener.class)
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    @OneToOne
    private Project project;
    private Date estimateDate;
    private Date expiryDate;
    private BigDecimal amount;
    private String otherInformation;
    private double percentageDiscount;
    @OneToMany(cascade = CascadeType.PERSIST,
            mappedBy = EstimateItem_.ESTIMATE)
    @JsonIgnoreProperties(EstimateItem_.ESTIMATE)
    @JsonProperty("estimateItems")
    private List<EstimateItem> items;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    User createdBy;

    public Long getId() {
        return id;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
        if(items!=null) {
            items.forEach(i -> i.setEstimate(this));
        }
        this.items = items;
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

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
