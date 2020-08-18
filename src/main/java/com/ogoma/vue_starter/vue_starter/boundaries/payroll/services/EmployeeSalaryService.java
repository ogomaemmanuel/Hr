package com.ogoma.vue_starter.vue_starter.boundaries.payroll.services;

import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollDeduction;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.models.PayslipViewModel;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollAdditionRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollDeductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryService {
    private final PayrollAdditionRepository payrollAdditionRepository;
    private final PayrollDeductionRepository payrollDeductionRepository;

    public EmployeeSalaryService(PayrollAdditionRepository payrollAdditionRepository, PayrollDeductionRepository payrollDeductionRepository) {
        this.payrollAdditionRepository = payrollAdditionRepository;
        this.payrollDeductionRepository = payrollDeductionRepository;
    }

    public PayslipViewModel getPayslipViewModelByEmployeeId(Long id) {
        List<PayrollAddition> payrollAdditions=
                this.payrollAdditionRepository.findAll();
        List<PayrollDeduction> payrollDeductions= this.payrollDeductionRepository.findAll();
        PayslipViewModel payslipViewModel = new PayslipViewModel(null,payrollAdditions,payrollDeductions);
        return payslipViewModel;
    }
}
