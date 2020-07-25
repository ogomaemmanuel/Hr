package com.ogoma.vue_starter.vue_starter.boundaries.payroll.services;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollAdditionRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollDeductionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<PayrollAddition> getPayrollAdditionById(Long id) {
        Optional<PayrollAddition> payrollAddition =
                this.payrollAdditionRepository.findById(id);
        return payrollAddition;
    }

    public Optional<PayrollAddition> upPayrollAddition(Long id, PayrollAddition payrollAddition) {
        Optional<PayrollAddition> payrollAddition1 = this.payrollAdditionRepository.findById(id);
        payrollAddition1.ifPresent(pa -> {
            pa.setAmount(payrollAddition.getAmount());
            pa.setName(payrollAddition.getName());
            this.payrollAdditionRepository.save(pa);
        });
        return payrollAddition1;
    }

    public void removePayrollAddition(Long id) {
        this.payrollAdditionRepository.deleteById(id);
    }


}
