package com.ogoma.vue_starter.vue_starter.boundaries.payroll;

import com.ogoma.vue_starter.vue_starter.authentication.CustomUserDetails;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.entities.EmployeePayrollAddition;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.models.EmployeeSalaryViewModel;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.models.PayslipViewModel;
import com.ogoma.vue_starter.vue_starter.boundaries.payroll.services.EmployeeSalaryService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import com.ogoma.vue_starter.vue_starter.utils.SecurityUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class EmployeeSalaryController {
    private final EmployeeSalaryService employeeSalaryService;

    public EmployeeSalaryController(EmployeeSalaryService employeeSalaryService) {
        this.employeeSalaryService = employeeSalaryService;
    }

    @RequestMapping(value = "/api/payslip/me", method = RequestMethod.GET)
    public ModelAndView getPayslip() {
        Employee employee = SecurityUtils.getCurrentUserDetails().getEmployee();
        PayslipViewModel payslipViewModel = employeeSalaryService.getPayslipViewModelByEmployeeId(employee.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("payroll/payslip");
        modelAndView.addObject("payslip", payslipViewModel);
        return modelAndView;
    }

    @RequestMapping(value = "api/employee-salary", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployeesSalary(PagedDataRequest pagedDataRequest) {
        Page<EmployeeSalaryViewModel> employeeSalaries =
                this.employeeSalaryService.getEmployeesSalary(pagedDataRequest);
        return ResponseEntity.ok(employeeSalaries);
    }

    @RequestMapping(value = "api/employee-salary/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployeesSalaryByEmployeeId(@PathVariable("id") Long employeeId) {
        EmployeeSalaryViewModel employeeSalaries =
                this.employeeSalaryService.getEmployeesSalaryByEmployeeId(employeeId);
        return ResponseEntity.ok(employeeSalaries);
    }

    @RequestMapping(value = "/api/payslip/{id}", method = RequestMethod.GET)
    public ModelAndView getPayslipByEmployeeId(@PathVariable("id") Long employeeId) {
        PayslipViewModel payslipViewModel = employeeSalaryService.getPayslipViewModelByEmployeeId(employeeId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("payroll/payslip");
        modelAndView.addObject("payslip", payslipViewModel);
        return modelAndView;
    }
    @RequestMapping(value = "/api/employee-payroll-addition", method = RequestMethod.POST)
    public ResponseEntity<?> createEmployeePayrollAllowance(
            @Valid @RequestBody EmployeePayrollAddition employeePayrollAddition) {
        this.employeeSalaryService.createPayrollAddition(employeePayrollAddition);
        return ResponseEntity.ok(employeePayrollAddition);
    }

}
