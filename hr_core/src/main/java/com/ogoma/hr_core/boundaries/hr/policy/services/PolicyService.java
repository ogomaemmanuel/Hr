package com.ogoma.hr_core.boundaries.hr.policy.services;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.Department;
import com.ogoma.hr_core.boundaries.hr.employee_management.repositories.DepartmentsRepository;
import com.ogoma.hr_core.boundaries.hr.policy.entities.Policy_;
import com.ogoma.hr_core.boundaries.hr.policy.repositories.PolicyRepository;
import com.ogoma.hr_core.boundaries.hr.policy.entities.Policy;
import com.ogoma.hr_core.boundaries.hr.policy.requests.PolicyRequest;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.Optional;

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

        //TODO upload  policyRequest attachment to s3 bucket and update url for policy
        Department department =
                this.departmentsRepository.getOne(policyRequest.getDepartmentId());
        Policy policy = new Policy();
        policy.setDescription(policyRequest.getDescription());
        policy.setName(policyRequest.getName());
        policy.addDepartment(department);
        this.policyRepository.save(policy);
        return policy;
    }

    public Optional<Policy> updatePolicy(Long id, PolicyRequest policyRequest) {
        //TODO upload  policyRequest attachment to s3 bucket and update url for policy
        Department department = this.departmentsRepository.getOne(policyRequest.getDepartmentId());
        Optional<Policy> policy =
                this.policyRepository.findById(id);
        policy.ifPresent(p -> {
            p.setName(policyRequest.getName());
            p.setDescription(policyRequest.getDescription());
            p.addDepartment(department);
            this.policyRepository.save(p);
        });
        return policy;
    }
    public void removePolicy(Long id) {
        this.policyRepository.deleteById(id);
    }

    public Optional<Policy> getPolicyById(Long id) {
        Optional<Policy> policy =
                this.policyRepository.getById(id);
        return policy;
    }
}
