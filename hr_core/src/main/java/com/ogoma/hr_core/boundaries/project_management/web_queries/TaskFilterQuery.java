package com.ogoma.hr_core.boundaries.project_management.web_queries;

import com.ogoma.hr_core.boundaries.project_management.entities.Task;
import com.ogoma.hr_core.boundaries.project_management.specifications.TaskSpecification;
import org.springframework.data.jpa.domain.Specification;

public class TaskFilterQuery {
    private Long projectId;
    private Long assignedEmployeeId;

    private String status;

    private Boolean active;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getAssignedEmployeeId() {
        return assignedEmployeeId;
    }

    public void setAssignedEmployeeId(Long assignedEmployeeId) {
        this.assignedEmployeeId = assignedEmployeeId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean status) {
        this.active = status;
    }

    public Specification<Task> taskSpecification(){
        return TaskSpecification.createSpecification(this);
    }

}
