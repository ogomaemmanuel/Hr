package com.ogoma.hr_core.boundaries.payroll.repositories;

import com.ogoma.hr_core.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollAdditionRepository extends BaseRepo<PayrollAddition> {
}
