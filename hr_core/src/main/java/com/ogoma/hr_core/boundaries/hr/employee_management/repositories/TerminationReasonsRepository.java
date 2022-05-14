package com.ogoma.hr_core.boundaries.hr.employee_management.repositories;

import com.ogoma.hr_core.boundaries.hr.employee_management.entities.TerminationReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminationReasonsRepository extends JpaRepository<TerminationReason, Long> {
}
