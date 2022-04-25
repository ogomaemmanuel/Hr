package com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.requests;

import com.ogoma.vue_starter.vue_starter.boundaries.performance.goals.entities.GoalType;

public class GoalTypeRequest {
    private String name;
    private String description;
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
