package com.ogoma.hr_core.boundaries.project_management.specifications;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Employee_;
import com.ogoma.hr_core.boundaries.project_management.entities.Project_;
import com.ogoma.hr_core.boundaries.project_management.entities.Task;
import com.ogoma.hr_core.boundaries.project_management.entities.Task_;
import com.ogoma.hr_core.boundaries.project_management.web_queries.TaskFilterQuery;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class TaskSpecification  {
    public static Specification<Task> createSpecification(TaskFilterQuery taskFilterQuery){
       return new Specification<>() {
           @Override
           public Predicate toPredicate(Root<Task> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
               ArrayList<Predicate> predicates = new ArrayList<>();
               if (taskFilterQuery != null) {
                   if (taskFilterQuery.getProjectId() != null) {
                       root.fetch(Task_.PROJECT, JoinType.LEFT);
                       predicates.add(criteriaBuilder.equal(root.get(Task_.PROJECT).get(Project_.ID), taskFilterQuery.getProjectId()));
                   }
                   if (taskFilterQuery.getAssignedEmployeeId() != null) {
                       root.fetch(Task_.ASSIGNED_EMPLOYEES, JoinType.LEFT);
                       predicates.add(criteriaBuilder.equal(root.<List<Employee>>get(Task_.ASSIGNED_EMPLOYEES).<List<Long>>get(Employee_.ID), taskFilterQuery.getAssignedEmployeeId()));
                   }
               }
               predicates.add(criteriaBuilder.equal(root.get(Task_.ACTIVE), taskFilterQuery.getActive()));

               return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
           }
       };
    }
}
