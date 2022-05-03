package com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.entities.GoalType;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class GoalTrackingRequest {
    @NotBlank
    private String subject;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date startDate;
    @JsonFormat(pattern  = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date endDate;
    @NotBlank
    private String description;

    private Long goalTypeID;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGoalTypeID() {
        return goalTypeID;
    }

    public void setGoalTypeID(Long goalType) {
        this.goalTypeID = goalType;
    }
}
