package com.ogoma.hr_core.boundaries.payroll.repositories;

import com.ogoma.hr_core.boundaries.payroll.entities.EmployeePayrollDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePayrollDeductionRepository extends JpaRepository<EmployeePayrollDeduction, Long> {
    @Nullable
    List<EmployeePayrollDeduction> findAllByEmployeeId(Long employeeId);
}
