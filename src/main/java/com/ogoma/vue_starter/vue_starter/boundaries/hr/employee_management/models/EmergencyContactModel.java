package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models;

import javax.validation.constraints.NotBlank;

public class EmergencyContactModel {
    Long id;
    @NotBlank(message = "Name is required")
    private String primaryName;
    @NotBlank(message = "Relationship is required")
    private String primaryRelationship;
    @NotBlank(message = "Phone number one required")
    private String primaryPhoneOne;
    private String primaryPhoneTwo = "";
    private String secondaryName;
    private String secondaryRelationship;
    private String secondaryPhoneOne = "";
    private String secondaryPhoneTwo = "";
    private Long userId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimaryName() {
        return primaryName;
    }
    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public String getPrimaryRelationship() {
        return primaryRelationship;
    }
    public void setPrimaryRelationship(String primaryRelationship) {
        this.primaryRelationship = primaryRelationship;
    }

    public String getPrimaryPhoneOne() {
        return primaryPhoneOne;
    }
    public void setPrimaryPhoneOne(String primaryPhoneOne) {
        this.primaryPhoneOne = primaryPhoneOne;
    }

    public String getPrimaryPhoneTwo() {
        return primaryPhoneTwo;
    }
    public void setPrimaryPhoneTwo(String primaryPhoneTwo) {
        this.primaryPhoneTwo = primaryPhoneTwo;
    }

    public String getSecondaryName() {
        return secondaryName;
    }
    public void setSecondaryName(String secondaryName) {
        this.secondaryName = secondaryName;
    }

    public String getSecondaryRelationship() {
        return secondaryRelationship;
    }
    public void setSecondaryRelationship(String secondaryRelationship) {
        this.secondaryRelationship = secondaryRelationship;
    }

    public String getSecondaryPhoneOne() {
        return secondaryPhoneOne;
    }
    public void setSecondaryPhoneOne(String secondaryPhoneOne) {
        this.secondaryPhoneOne = secondaryPhoneOne;
    }

    public String getSecondaryPhoneTwo() {
        return secondaryPhoneTwo;
    }
    public void setSecondaryPhoneTwo(String secondaryPhoneTwo) {
        this.secondaryPhoneTwo = secondaryPhoneTwo;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
