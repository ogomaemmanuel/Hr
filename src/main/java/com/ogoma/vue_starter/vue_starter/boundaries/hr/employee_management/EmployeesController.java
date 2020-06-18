package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Employee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.EmployeesService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class EmployeesController {
    private final EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @RequestMapping(value = "api/employees", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployees(PagedDataRequest pagedDataRequest) {
        Page<Employee> employees = this.employeesService.getEmployees(pagedDataRequest);
        return ResponseEntity.ok(employees);
    }

    @RequestMapping(value = "api/employees", method = RequestMethod.POST)
    public ResponseEntity<?> createEmployee(@RequestBody  EmployeeCreateModel employeeCreateModel) {
        Employee employee = this.employeesService.createEmployee(employeeCreateModel);
        return ResponseEntity.ok(employee);
    }


}
