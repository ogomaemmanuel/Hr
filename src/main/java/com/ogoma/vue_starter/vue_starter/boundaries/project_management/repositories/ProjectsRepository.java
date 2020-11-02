package com.ogoma.vue_starter.vue_starter.boundaries.project_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ProjectProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<Project, Long> {
    @Query(value = "select id, name,start_date,end_date,description from projects",
            nativeQuery = true,
            countQuery = "select count(*) from projects")
    public Page<ProjectProjection> getProjects(Pageable pageable);
}
