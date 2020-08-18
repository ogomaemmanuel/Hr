package com.ogoma.vue_starter.vue_starter.boundaries.payroll.services;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollAdditionRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollDeductionRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayrollAdditionsService {
    private final PayrollAdditionRepository payrollAdditionRepository;

    public PayrollAdditionsService(PayrollAdditionRepository payrollAdditionRepository) {
        this.payrollAdditionRepository = payrollAdditionRepository;
    }

    public Page<PayrollAddition> getPayrollAdditions(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<PayrollAddition> payrollAdditions =
                this.payrollAdditionRepository.findAll(pageRequest);
        return payrollAdditions;
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
            pa.setCalculation(payrollAddition.getCalculation());
            this.payrollAdditionRepository.save(pa);
        });
        return payrollAddition1;
    }
    public void removePayrollAddition(Long id) {
        this.payrollAdditionRepository.deleteById(id);
    }


}
