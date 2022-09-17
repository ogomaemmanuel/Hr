package com.ogoma.hr_core.boundaries.performance.goals.requests;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Date;

public class GoalRequest {
    @NotBlank
    private String subject;
    private LocalDate startDate;
    private LocalDate endDate;
    @NotBlank
    private String description;
    private String targetAchievement;
    @JsonAlias("goalTypeId")
    private Long goalTypeID;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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

    public String getTargetAchievement() {
        return targetAchievement;
    }

    public void setTargetAchievement(String targetAchievement) {
        this.targetAchievement = targetAchievement;
    }
}
