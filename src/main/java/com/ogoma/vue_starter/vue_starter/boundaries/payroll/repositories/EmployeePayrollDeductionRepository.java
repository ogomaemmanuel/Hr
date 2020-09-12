package com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.EmployeePayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.EmployeePayrollDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface EmployeePayrollDeductionRepository extends JpaRepository<EmployeePayrollDeduction,Long> {
    @Nullable
    List<EmployeePayrollDeduction> findAllByEmployeeId(Long employeeId);
}
