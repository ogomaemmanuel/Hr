package com.ogoma.hr_core.boundaries.project_management.repositories;

import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import com.ogoma.hr_core.boundaries.project_management.entities.Project;
import com.ogoma.hr_core.boundaries.project_management.models.ProjectProjection;
import com.ogoma.hr_core.boundaries.project_management.models.TeamMemberProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectsRepository extends BaseRepo<Project> {
    @Query(value = "select id, name,start_date as startDate,end_date as endDate,description from projects",
            nativeQuery = true,
            countQuery = "select count(*) from projects")
    public Page<ProjectProjection> getProjects(Pageable pageable);

    @Query(value = "select p.id, p.name,p.start_date as startDate,p.end_date as endDate," +
            "p.created_at as createdAt,p.description, le.id as leadEmployeeId, leu.first_name as leadFirstName, " +
            "leu.last_name as leadLastName,led.name as leadDesignation, c.id as clientId," +
            "cu.first_name as clientFirstName,cu.last_name as clientLastName from projects p left " +
            "join employees le  on p.team_leader_id = le.id left join  users leu  on le.user_id = leu.id left join " +
            "designations led on le.designation_id = led.id left join clients c on p.client_id = c.id left join " +
            "users cu on c.user_id=cu.id  where p.id=:projectId",
            nativeQuery = true)
    public Optional<ProjectProjection> getProjectsDetails(Long projectId);

    @Query(value = "select pm.project_id as projectId,pm.employee_id as employeeId,u.last_name as lastName, u.first_name as firstName, d.name as designation " +
            " from project_members pm left join employees e on pm.employee_id = e.id left join users u on e.user_id = u.id " +
            "left join designations d on e.designation_id = d.id where pm.project_id=:projectId",
            nativeQuery = true, countQuery = "select count(*) from project_members where project_id=:projectId")
    Page<TeamMemberProjection> getProjectTeamMembers(Long projectId, Pageable pageable);
}
