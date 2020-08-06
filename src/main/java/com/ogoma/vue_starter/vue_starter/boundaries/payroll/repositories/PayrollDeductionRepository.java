package com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollDeduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollDeductionRepository extends JpaRepository<PayrollDeduction,Long> {
}
