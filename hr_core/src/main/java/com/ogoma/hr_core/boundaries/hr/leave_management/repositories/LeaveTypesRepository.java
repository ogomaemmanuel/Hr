package com.ogoma.hr_core.boundaries.hr.leave_management.repositories;

import com.ogoma.hr_core.boundaries.hr.leave_management.entities.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypesRepository extends JpaRepository<LeaveType, Long> {


}
