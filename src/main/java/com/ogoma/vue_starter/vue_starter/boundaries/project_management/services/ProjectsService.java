package com.ogoma.vue_starter.vue_starter.boundaries.project_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ProjectDto;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ProjectProjection;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.ProjectsRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {
    private final ProjectsRepository projectsRepository;
    private final EmployeeRepository employeeRepository;

    public ProjectsService(ProjectsRepository projectsRepository, EmployeeRepository employeeRepository) {
        this.projectsRepository = projectsRepository;
        this.employeeRepository = employeeRepository;
    }

    public Page<ProjectProjection> getProjects(PagedDataRequest pagedDataRequest) {
        Pageable pageable = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<ProjectProjection> projects =
                this.projectsRepository.getProjects(pageable);
        return projects;
    }

    public Project createProject(ProjectDto projectDto) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDto, project);
        List<Employee> teamMembers =
                this.employeeRepository.findAllById(projectDto.getProjectMembersIds());
        project.setProjectMembers(teamMembers);
        project = this.projectsRepository.save(project);
        return project;
    }

    public Optional<Project> getProjectByID(Long id) {
        Optional<Project> project =
                this.projectsRepository.findById(id);
        return project;
    }

    public void removeProjectByID(Long id) {
        this.projectsRepository.deleteById(id);
    }

    public Optional<Project> updateProject(Long id, ProjectDto project) {
        Optional<Project> optionalProject =
                this.projectsRepository.findById(id);
        optionalProject.ifPresent(pr -> {
            pr.setDescription(project.getDescription());
            pr.setName(project.getName());
            pr.setRate(project.getRate());
            pr.setEndDate(project.getEndDate());
            pr.setStartDate(project.getStartDate());
            this.projectsRepository.save(pr);
        });
        return optionalProject;
    }

    public Optional<ProjectProjection> getProjectDescription(Long projectId) {
        Optional<ProjectProjection> projectProjection
                = this.projectsRepository.getProjectsDetails(projectId);
        return projectProjection;
    }
}
