package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminatedEmployee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.TerminatedEmployeesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class TerminatedEmployeesController {
    private final TerminatedEmployeesService terminatedEmployeesService;

    public TerminatedEmployeesController(TerminatedEmployeesService terminatedEmployeesService) {
        this.terminatedEmployeesService = terminatedEmployeesService;
    }

    @RequestMapping(value = "api/employee-terminations", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody @Valid TerminatedEmployee terminatedEmployee) {
        terminatedEmployee = this.terminatedEmployeesService.createTermination(terminatedEmployee);
        return ResponseEntity.ok(terminatedEmployee);
    }
}
