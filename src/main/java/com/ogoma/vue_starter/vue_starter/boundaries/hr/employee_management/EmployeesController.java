package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.EmployeesService;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeesController {
    private final EmployeesService employeesService;
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }
}
