package com.ogoma.hr_core.boundaries.asset_management.requests;

import com.ogoma.hr_core.boundaries.asset_management.entities.Asset;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class AssetRequest {
    @NotBlank(message = "Asset name is required")
    private String name;
    @NotBlank(message = "Purchase From is required")
    private String purchasedFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Purchase Date is required")
    private Date purchaseDate;
    private String manufacturer;
    private String model;
    private String serialNumber;
    private String supplier;
    private String condition;
    private Integer warrantyInMonths;
    private BigDecimal value;
    private Long assetUserId;
    private String description;
    @Enumerated(EnumType.STRING)
    private Asset.Status status;

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

    public Long getAssetUserId() {
        return assetUserId;
    }

    public void setAssetUserId(Long assetUserId) {
        this.assetUserId = assetUserId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Asset.Status getStatus() {
        return status;
    }

    public void setStatus(Asset.Status status) {
        this.status = status;
    }
}
