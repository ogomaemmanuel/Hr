package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "leave_types")
@EntityListeners(AuditingEntityListener.class)
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    //@NotNull(message = "Number of days is required")
    private Integer numberOfDays;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public LeaveType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LeaveType setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public LeaveType setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public LeaveType setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public LeaveType setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
