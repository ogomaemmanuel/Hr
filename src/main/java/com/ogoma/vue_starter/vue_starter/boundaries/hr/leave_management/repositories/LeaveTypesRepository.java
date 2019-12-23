package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypesRepository extends JpaRepository<LeaveType, Long> {

}
