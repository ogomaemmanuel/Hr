package com.ogoma.hr_core.boundaries.performance.goals.requests;

import com.ogoma.hr_core.boundaries.performance.goals.entities.GoalType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class GoalTypeRequest {
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private GoalType.Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GoalType.Status getStatus() {
        return status;
    }

    public void setStatus(GoalType.Status status) {
        this.status = status;
    }
}
