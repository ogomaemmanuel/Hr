package com.ogoma.hr_core.boundaries.payroll.repositories;

import com.ogoma.hr_core.boundaries.payroll.entities.PayrollDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollDeductionRepository extends JpaRepository<PayrollDeduction,Long> {
}
