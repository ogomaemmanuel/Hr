package com.ogoma.hr_core.boundaries.hr.employee_management.entities;

import com.ogoma.hr_core.boundaries.hr.employee_management.enums.Statuses;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shifts")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    String name;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Enumerated(value =  EnumType.STRING)
    private Statuses statuses;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Temporal(TemporalType.TIMESTAMP)
    private  Date updatedOn;

    public Long getId() {
        return id;
    }

    public Shift setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Shift setName(String name) {
        this.name = name;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Shift setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Shift setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Statuses getStatuses() {
        return statuses;
    }

    public Shift setStatuses(Statuses statuses) {
        this.statuses = statuses;
        return this;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Shift setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public Shift setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
