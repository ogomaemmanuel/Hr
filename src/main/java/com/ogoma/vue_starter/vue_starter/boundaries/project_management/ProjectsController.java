package com.ogoma.vue_starter.vue_starter.boundaries.project_management;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ProjectDto;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.services.ProjectsService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ProjectsController {
    private final ProjectsService projectsService;

    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @RequestMapping(value = "api/projects", method = RequestMethod.GET)
    public ResponseEntity<?> getProjects(PagedDataRequest pagedDataRequest) {
        Page<Project> projects = this.projectsService.getProjects(pagedDataRequest);
        return ResponseEntity.ok(projects);
    }

    @RequestMapping(value = "api/projects", method = RequestMethod.POST)
    public ResponseEntity<?> createProject(@Valid ProjectDto projectDto) {
        Project project = this.projectsService.createProject(projectDto);
        return ResponseEntity.ok(project);
    }
}
