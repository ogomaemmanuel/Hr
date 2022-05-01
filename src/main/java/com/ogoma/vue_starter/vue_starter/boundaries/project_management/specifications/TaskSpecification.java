package com.ogoma.vue_starter.vue_starter.boundaries.project_management.specifications;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee_;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project_;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Task;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Task_;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.web_queries.TaskFilterQuery;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

public class TaskSpecification  {
    public static Specification<Task> createSpecification(TaskFilterQuery taskFilterQuery){
       return  new Specification<Task>() {
           @Override
           public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
               if(taskFilterQuery!=null) {
                   if (taskFilterQuery.getProjectId() != null) {
                       root.fetch(Task_.project, JoinType.LEFT);
                       criteriaBuilder.equal(root.get(Project_.ID), taskFilterQuery.getProjectId());
                   }
                   if (taskFilterQuery.getAssignedEmployeeId() != null) {
                       root.fetch(Task_.ASSIGNED_EMPLOYEES, JoinType.LEFT);
                       criteriaBuilder.equal(root.<List<Employee>>get(Task_.ASSIGNED_EMPLOYEES).<List<Long>>get(Employee_.ID), taskFilterQuery.getAssignedEmployeeId());
                   }
               }
               return criteriaBuilder.conjunction();
           }
       };
    }
}
