package com.ogoma.vue_starter.vue_starter.boundaries.project_management;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.services.ProjectsService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectsController {
    private final ProjectsService projectsService;

    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @RequestMapping(value = "api/projects")
    public ResponseEntity<?> getProjects(PagedDataRequest pagedDataRequest) {
        Page<Project> projects = this.projectsService.getProjects(pagedDataRequest);
        return ResponseEntity.ok(projects);
    }
}
