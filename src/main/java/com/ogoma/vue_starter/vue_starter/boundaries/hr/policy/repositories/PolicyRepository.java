package com.ogoma.vue_starter.vue_starter.boundaries.hr.policy.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.policy.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long>, JpaSpecificationExecutor<Policy> {


}
