package com.ogoma.vue_starter.vue_starter.boundaries.project_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ProjectDto;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories.ProjectsRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectsService {
    private final ProjectsRepository projectsRepository;

    public ProjectsService(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    public Page<Project> getProjects(PagedDataRequest pagedDataRequest) {
        Pageable pageable = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<Project> projects =
                this.projectsRepository.findAll(pageable);
        return projects;
    }

    public Project createProject(ProjectDto projectDto) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDto, project);
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

    public Optional<Project> updateProject(Long id, Project project) {
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
}
