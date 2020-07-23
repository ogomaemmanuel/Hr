package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminatedEmployee;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.TerminationReason;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.TerminatedEmployeeView;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.TerminatedEmployeesService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TerminatedEmployeesController {
    private final TerminatedEmployeesService terminatedEmployeesService;

    public TerminatedEmployeesController(TerminatedEmployeesService terminatedEmployeesService) {
        this.terminatedEmployeesService = terminatedEmployeesService;
    }

    @RequestMapping(value = "api/employee-terminations", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(PagedDataRequest pagedDataRequest) {
        Page<TerminatedEmployeeView> terminatedEmployeeViews =
                this.terminatedEmployeesService.getAll(pagedDataRequest);
        return ResponseEntity.ok(terminatedEmployeeViews);
    }

    @RequestMapping(value = "api/employee-terminations/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeTerminatedEmployee(@PathVariable("id") Long id) {
        this.terminatedEmployeesService.removeTerminatedEmployee(id);
        return ResponseEntity.ok("Terminated employee successfully removed");
    }

    @RequestMapping(value = "api/employee-terminations", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody @Valid TerminatedEmployee terminatedEmployee) {
        terminatedEmployee = this.terminatedEmployeesService.createTermination(terminatedEmployee);
        return ResponseEntity.ok(terminatedEmployee);
    }

    @RequestMapping(value = "api/employee-terminations/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody TerminatedEmployee terminatedEmployee) {
        Optional<TerminatedEmployee> terminatedEmployeeOptional =
                this.terminatedEmployeesService.updateTermination(id, terminatedEmployee);
        return ResponseEntity.of(terminatedEmployeeOptional);
    }

    @RequestMapping(value = "/api/employee-terminations/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        Optional<TerminatedEmployee> terminatedEmployee =
                this.terminatedEmployeesService.getTerminationById(id);
        return ResponseEntity.of(terminatedEmployee);
    }

    @RequestMapping(value = "api/employee-terminations-reasons", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployeeTerminationReasons() {
        List<TerminationReason> terminationReasons =
                this.terminatedEmployeesService.getTerminationReasons();
        return ResponseEntity.ok(terminationReasons);
    }
}
