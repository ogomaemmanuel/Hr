package com.ogoma.hr_core.boundaries.project_management.models;

import java.util.List;

public class TaskCreateRequest {
    private String title;
    private String description;
    private List<Long> assignedEmployeesId;
    private Long projectId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getAssignedEmployeesId() {
        return assignedEmployeesId;
    }

    public void setAssignedEmployeesId(List<Long> assignedEmployeesId) {
        this.assignedEmployeesId = assignedEmployeesId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
