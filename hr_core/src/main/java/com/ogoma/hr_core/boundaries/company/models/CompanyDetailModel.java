package com.ogoma.hr_core.boundaries.company.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CompanyDetailModel {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Website URL is required")
    private String websiteUrl;
    @NotBlank(message = "Company Registration No. is required")
    private String registrationNo;
    @NotNull(message = "Date of establishment is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateEstablished;
    @NotBlank(message = "Business Description is required")
    private String businessDescription;
    @NotBlank(message = "Business entity type is required")
    private String businessEntityType;
    @NotBlank(message = "State of incorporation is required")
    private String stateOfIncorporation;
    @NotBlank(message = "Email is required")
    private String email;
    private String logoUrl;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }
    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Date getDateEstablished() {
        return dateEstablished;
    }
    public void setDateEstablished(Date dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }
    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public String getBusinessEntityType() {
        return businessEntityType;
    }
    public void setBusinessEntityType(String businessEntityType) {
        this.businessEntityType = businessEntityType;
    }

    public String getStateOfIncorporation() {
        return stateOfIncorporation;
    }
    public void setStateOfIncorporation(String stateOfIncorporation) {
        this.stateOfIncorporation = stateOfIncorporation;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogoUrl() {
        return logoUrl;
    }
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
