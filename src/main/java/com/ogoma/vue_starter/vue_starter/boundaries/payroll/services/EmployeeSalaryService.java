package com.ogoma.vue_starter.vue_starter.boundaries.payroll.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.EmployeePayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.PayrollDeduction;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.models.EmployeeSalaryViewModel;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.models.PayslipViewModel;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.EmployeePayrollAdditionRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollAdditionRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.repositories.PayrollDeductionRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSalaryService {
    private final PayrollAdditionRepository payrollAdditionRepository;
    private final PayrollDeductionRepository payrollDeductionRepository;
    private final EmployeePayrollAdditionRepository employeePayrollAdditionRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeSalaryService(PayrollAdditionRepository payrollAdditionRepository,
                                 PayrollDeductionRepository payrollDeductionRepository,
                                 EmployeePayrollAdditionRepository employeePayrollAdditionRepository,
                                 EmployeeRepository employeeRepository) {
        this.payrollAdditionRepository = payrollAdditionRepository;
        this.payrollDeductionRepository = payrollDeductionRepository;
        this.employeePayrollAdditionRepository = employeePayrollAdditionRepository;
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

    public EmployeeSalaryViewModel getEmployeesSalaryByEmployeeId(Long employeeId) {
        EmployeeSalaryViewModel employeeSalaryViewModel =
                this.employeeRepository.getEmployeeSalaryByEmployeeId(employeeId);
        return employeeSalaryViewModel;
    }

    public EmployeePayrollAddition createPayrollAddition(EmployeePayrollAddition employeePayrollAddition) {
        this.employeePayrollAdditionRepository.save(employeePayrollAddition);
        return employeePayrollAddition;
    }
}
