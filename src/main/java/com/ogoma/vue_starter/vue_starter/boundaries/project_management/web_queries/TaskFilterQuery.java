package com.ogoma.vue_starter.vue_starter.boundaries.project_management.web_queries;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Task;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.specifications.TaskSpecification;
import org.springframework.data.jpa.domain.Specification;

public class TaskFilterQuery {
    private Long projectId;
    private Long assignedEmployeeId;

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

   public Specification<Task> taskSpecification(){
        return TaskSpecification.createSpecification(this);
    }
}
