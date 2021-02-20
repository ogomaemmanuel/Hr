package com.ogoma.vue_starter.vue_starter.boundaries.project_management.specifications;

import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project_;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.models.ProjectPagedDataRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class ProjectsSpecifications {

    public static Specification<Project> getProjectSpec(ProjectPagedDataRequest pagedDataRequest) {
        return new Specification<Project>() {
            @Override
            public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                if (Long.class != criteriaQuery.getResultType()) {
                    if (pagedDataRequest.getClientId() != null) {
                        root.fetch(Project_.CLIENT, JoinType.LEFT);
                        criteriaBuilder.equal(root.get(Project_.CLIENT), pagedDataRequest.getClientId());
                    }
                    if (pagedDataRequest.getEmployeeId() != null) {
                        root.fetch(Project_.projectMembers,JoinType.LEFT);
                        criteriaBuilder.equal(root.get(Project_.projectMembers), pagedDataRequest.getEmployeeId());
                    }
                }
                return criteriaBuilder.conjunction();
            }
        };
    }
}
