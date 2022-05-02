package com.ogoma.vue_starter.vue_starter.boundaries.project_management.models;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.specifications.ProjectsSpecifications;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.jpa.domain.Specification;

public class ProjectPagedDataRequest extends PagedDataRequest {
    private Long clientId;
    private String projectName;
    private Long employeeId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Specification<Project> getSpecification() {
        return ProjectsSpecifications.getProjectSpec(this);
    }
}
