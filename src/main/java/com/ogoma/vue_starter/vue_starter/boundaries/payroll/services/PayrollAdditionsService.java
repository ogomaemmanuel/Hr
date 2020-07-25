package com.ogoma.vue_starter.vue_starter.boundaries.payroll.services;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollAdditionRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollDeductionRepository;
import org.springframework.stereotype.Service;

@Service
public class PayrollAdditionsService {
    private final PayrollAdditionRepository payrollAdditionRepository;
    private final PayrollDeductionRepository payrollDeductionRepository;

    public PayrollAdditionsService(PayrollAdditionRepository payrollAdditionRepository,
                                   PayrollDeductionRepository payrollDeductionRepository) {
        this.payrollAdditionRepository = payrollAdditionRepository;
        this.payrollDeductionRepository = payrollDeductionRepository;
    }

    public PayrollAddition createPayrollAddition(PayrollAddition payrollAddition) {
        this.payrollAdditionRepository.save(payrollAddition);
        return payrollAddition;
    }


}
