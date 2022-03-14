package com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emergency_contacts")
public class EmergencyContact{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "primary_name")
    private String primaryName;

    @Column(name = "primary_relationship")
    private String primaryRelationship;

    @Column(name = "primary_phone_one")
    private String primaryPhoneOne;

    @Column(name = "primary_phone_two")
    private String primaryPhoneTwo;

    @Column(name = "secondary_name")
    private String secondaryName;

    @Column(name = "secondary_relationship")
    private String secondaryRelationship;

    @Column(name = "secondary_phone_one")
    private String secondaryPhoneOne;

    @Column(name = "secondary_phone_two")
    private String secondaryPhoneTwo;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

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

    public Long getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }
}
