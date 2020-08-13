package com.ogoma.vue_starter.vue_starter.boundaries.payroll.services;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollDeduction;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollDeductionRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PayrollDeductionService {
    private final PayrollDeductionRepository payrollDeductionRepository;

    public PayrollDeductionService(PayrollDeductionRepository payrollDeductionRepository) {
        this.payrollDeductionRepository = payrollDeductionRepository;
    }
    public Page<PayrollDeduction> getPayrollDeductions(PagedDataRequest pagedDataRequest) {
        Pageable pageable = PageRequest.of(pagedDataRequest.getPage(),
                pagedDataRequest.getPageSize());
        Page<PayrollDeduction> payrollDeductions =
                this.payrollDeductionRepository.findAll(pageable);
        return payrollDeductions;
    }
    public PayrollDeduction createPayrollDeduction(PayrollDeduction payrollDeduction) {
        payrollDeduction = this.payrollDeductionRepository.save(payrollDeduction);
        return payrollDeduction;
    }

}
