package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.TerminatedEmployeesService;
import org.springframework.stereotype.Controller;

@Controller
public class TerminatedEmployeesController {
    private final TerminatedEmployeesService terminatedEmployeesService;
    public TerminatedEmployeesController(TerminatedEmployeesService terminatedEmployeesService) {
        this.terminatedEmployeesService = terminatedEmployeesService;
    }
}
