package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeCreateModel;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeesService {
    private final EmployeeRepository employeeRepository;

    public EmployeesService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(EmployeeCreateModel employeeCreateModel) {
        return;
    }
}
