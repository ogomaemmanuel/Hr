package com.ogoma.hr_core.boundaries.hr.policy.repositories;

import com.ogoma.hr_core.boundaries.hr.policy.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long>, JpaSpecificationExecutor<Policy> {
    @Query(value = "select p from Policy p left join fetch p.departments where p.id=:id")
    Optional<Policy> getById(Long id);
}
