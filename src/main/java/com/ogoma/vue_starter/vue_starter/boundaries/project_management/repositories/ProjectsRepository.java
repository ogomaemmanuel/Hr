package com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ProjectProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectsRepository extends JpaRepository<Project, Long> {
    @Query(value = "select id, name,start_date as startDate,end_date as endDate,description from projects",
            nativeQuery = true,
            countQuery = "select count(*) from projects")
    public Page<ProjectProjection> getProjects(Pageable pageable);

    @Query(value = "select id, name,start_date as startDate,end_date as endDate,description from projects",
            nativeQuery = true)
    public Optional<ProjectProjection> getProjectsDetails(Long projectId);
}
