package com.ogoma.hr_core.boundaries.payroll.repositories;

import com.ogoma.hr_core.boundaries.payroll.entities.EmployeePayrollAddition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePayrollAdditionRepository extends JpaRepository<EmployeePayrollAddition, Long> {

    @Nullable
    List<EmployeePayrollAddition> findAllByEmployeeId(Long employeeId);
}
