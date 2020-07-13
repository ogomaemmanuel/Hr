package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminatedEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminatedEmployeeRepository extends JpaRepository<TerminatedEmployee,Long> {
}
