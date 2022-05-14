package com.ogoma.hr_core.boundaries.hr.policy.controllers;

import com.ogoma.hr_core.boundaries.hr.policy.entities.Policy;
import com.ogoma.hr_core.boundaries.hr.policy.requests.PolicyRequest;
import com.ogoma.hr_core.boundaries.hr.policy.services.PolicyService;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping(value = "api/policies")
public class PolicyController {
    static Logger logger
            = LoggerFactory.getLogger(PolicyController.class);
    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public ResponseEntity<?> getPolicies(PagedDataRequest pagedDataRequest) {
        Page<Policy> policies = this.policyService.getPolicies(pagedDataRequest);
        System.out.println(policies);
        return ResponseEntity.ok(policies);
    }

    @PostMapping
    public ResponseEntity<?> createPolicy(@Valid PolicyRequest policyRequest) {
        Policy policy = this.policyService.createPolicy(policyRequest);
        return ResponseEntity.ok(policy);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getPolicyById(@PathVariable Long id) {
        Optional<Policy> policy = this.policyService.getPolicyById(id);
        return ResponseEntity.of(policy);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updatePolicy(@PathVariable("id") Long id, @Valid PolicyRequest policyRequest) {
        Optional<Policy> policy = this.policyService.updatePolicy(id, policyRequest);
        return ResponseEntity.of(policy);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> removePolicy(@PathVariable Long id) {
        this.policyService.removePolicy(id);
        return ResponseEntity.ok("policy successfully removed");
    }


}
