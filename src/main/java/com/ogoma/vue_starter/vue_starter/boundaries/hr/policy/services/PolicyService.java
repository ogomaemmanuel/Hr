package com.ogoma.vue_starter.vue_starter.boundaries.hr.policy.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Department;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.DepartmentsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.policy.entities.Policy_;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.policy.repositories.PolicyRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.policy.entities.Policy;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.policy.requests.PolicyRequest;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;

@Service
public class PolicyService {
    private final PolicyRepository policyRepository;
    private final DepartmentsRepository departmentsRepository;

    public PolicyService(PolicyRepository policyRepository,
                         DepartmentsRepository departmentsRepository) {
        this.policyRepository = policyRepository;
        this.departmentsRepository = departmentsRepository;
    }

    public Page<Policy> getPolicies(PagedDataRequest pagedDataRequest) {

        Page<Policy> policies = this.policyRepository.findAll(
                (root, query, queryBuilder) -> {
                    if (Long.class != query.getResultType()) {
                        root.fetch(Policy_.DEPARTMENTS, JoinType.LEFT);
                    }
                    return queryBuilder.conjunction();
                }, pagedDataRequest.toPageable());
        return policies;
    }

    public Policy createPolicy(PolicyRequest policyRequest) {
        Department department =
                this.departmentsRepository.getOne(policyRequest.getDepartmentId());
        Policy policy = new Policy();
        policy.setDescription(policyRequest.getDescription());
        policy.setName(policyRequest.getName());
        policy.addDepartment(department);
        this.policyRepository.save(policy);
        return policy;
    }
}
