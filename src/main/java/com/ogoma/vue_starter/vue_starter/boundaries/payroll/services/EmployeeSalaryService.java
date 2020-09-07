package com.ogoma.vue_starter.vue_starter.boundaries.payroll.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollDeduction;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.models.EmployeeSalaryViewModel;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.models.PayslipViewModel;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollAdditionRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollDeductionRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSalaryService {
    private final PayrollAdditionRepository payrollAdditionRepository;
    private final PayrollDeductionRepository payrollDeductionRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeSalaryService(PayrollAdditionRepository payrollAdditionRepository,
                                 PayrollDeductionRepository payrollDeductionRepository,
                                 EmployeeRepository employeeRepository) {
        this.payrollAdditionRepository = payrollAdditionRepository;
        this.payrollDeductionRepository = payrollDeductionRepository;
        this.employeeRepository = employeeRepository;
    }

    public PayslipViewModel getPayslipViewModelByEmployeeId(Long id) {
        // TODO throw exception when an employee is not found
        Employee employee = this.employeeRepository.findById(id).orElse(null);
        List<PayrollAddition> payrollAdditions =
                this.payrollAdditionRepository.findAll();
        List<PayrollDeduction> payrollDeductions = this.payrollDeductionRepository.findAll();
        PayslipViewModel payslipViewModel =
                new PayslipViewModel(employee, payrollAdditions, payrollDeductions);
        return payslipViewModel;
    }
    public Page<EmployeeSalaryViewModel> getEmployeesSalary(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest =
                PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<EmployeeSalaryViewModel> employeesSalary =
                this.employeeRepository.getEmployeesSalary(pageRequest);
        return employeesSalary;
    }
}
