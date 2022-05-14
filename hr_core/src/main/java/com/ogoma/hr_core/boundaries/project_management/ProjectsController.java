package com.ogoma.hr_core.boundaries.project_management;

import com.ogoma.hr_core.boundaries.project_management.entities.Project;
import com.ogoma.hr_core.boundaries.project_management.models.*;
import com.ogoma.hr_core.boundaries.project_management.services.ProjectsService;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ProjectsController {
    private final ProjectsService projectsService;

    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @RequestMapping(value = "api/projects", method = RequestMethod.GET)
    public ResponseEntity<?> getProjects(ProjectPagedDataRequest pagedDataRequest) {
        Page<ProjectProjection> projects = this.projectsService.getProjects(pagedDataRequest);
        return ResponseEntity.ok(projects);
    }

    @RequestMapping(value = "api/projects/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProjectById(@PathVariable("id") Long projectId) {
        Optional<Project> project = this.projectsService.getProjectByID(projectId);
        return ResponseEntity.of(project);
    }

    @RequestMapping(value = "api/projects", method = RequestMethod.POST)
    public ResponseEntity<?> createProject(@Valid ProjectDto projectDto) {
        Project project = this.projectsService.createProject(projectDto);
        return ResponseEntity.ok(project);
    }

    @RequestMapping(value = "api/projects/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProjectById(@PathVariable("id") Long projectId, @Valid ProjectDto projectDto) {
        Optional<Project> project = this.projectsService.updateProject(projectId, projectDto);
        return ResponseEntity.of(project);
    }

    @RequestMapping(value = "api/projects/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProjectById(@PathVariable("id") Long projectId) {
        projectsService.removeProjectByID(projectId);
        return ResponseEntity.ok("Project successfully Removed");
    }

    @RequestMapping(value = "api/projects/details/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProjectDetails(@PathVariable("id") Long projectId) {
        Optional<ProjectProjection> projectProjection =
                this.projectsService.getProjectDescription(projectId);
        return ResponseEntity.of(projectProjection);
    }

    @RequestMapping(value = "api/projects/team-members/{projectId}", method = RequestMethod.POST)
    public ResponseEntity<?> updateProjectTeamMembers(@PathVariable Long projectId,
                                                      @RequestBody @Valid ProjectMemberUpdateDto memberUpdateDto) {
        this.projectsService.updateProjectTeamMembers(projectId, memberUpdateDto);
        return ResponseEntity.ok("Project team members successfully updated");
    }

    @RequestMapping(value = "api/projects/team-members/{projectId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProjectTeamMembers(@PathVariable Long projectId,PagedDataRequest pagedDataRequest) {
        Page<TeamMemberProjection> teamMembers =
                this.projectsService.getProjectTeamMembers(projectId, pagedDataRequest);
        return ResponseEntity.ok(teamMembers);
    }
}
