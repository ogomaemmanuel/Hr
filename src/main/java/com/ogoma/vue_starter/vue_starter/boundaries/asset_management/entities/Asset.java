package com.ogoma.vue_starter.vue_starter.boundaries.asset_management.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "assets", indexes = {
//        @Index(name = "name",)
})
public class Asset {
    public enum Status {
        Pending,
        Approved,
        Deployed,
        Damaged,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String purchasedFrom;
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    private String manufacturer;
    private String model;
    private String serialNumber;
    private String supplier;
    @Column(name = "[condition]")
    private String condition;
    private Integer warrantyInMonths;
    //column name is enclosed by [] since value is a keyword in mysql, without the [] an exemption is thrown
    @Column(name = "[value]")
    private BigDecimal value;
    @ManyToOne(fetch = FetchType.LAZY)
    private User assetUser;
    private String description;
    @Enumerated(EnumType.STRING)
    //column name is enclosed by [] since status is a keyword in mysql
    @Column(name = "[status]")
    private Status status;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurchasedFrom() {
        return purchasedFrom;
    }

    public void setPurchasedFrom(String purchasedFrom) {
        this.purchasedFrom = purchasedFrom;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getWarrantyInMonths() {
        return warrantyInMonths;
    }

    public void setWarrantyInMonths(Integer warrantyInMonths) {
        this.warrantyInMonths = warrantyInMonths;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public User getAssetUser() {
        return assetUser;
    }

    public void setAssetUser(User assetUser) {
        this.assetUser = assetUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
}
