package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.EmployeeResignation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.EmployeeResignationView;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.requests.ResignationRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.EmployeeResignationService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class EmployeeResignationController {
    private final EmployeeResignationService employeeResignationService;

    public EmployeeResignationController(EmployeeResignationService employeeResignationService) {
        this.employeeResignationService = employeeResignationService;
    }
    @RequestMapping(value = "api/employee-resignations", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployeeResignations(PagedDataRequest pagedDataRequest) {
        Page<EmployeeResignationView> employeeResignationViews
                = this.employeeResignationService.getEmployeeResignations(pagedDataRequest);
        return ResponseEntity.ok(employeeResignationViews);
    }
    @RequestMapping(value = "api/employee-resignations", method = RequestMethod.POST)
    public ResponseEntity<?> saveEmployeeResignation(@RequestBody @Valid ResignationRequest resignationRequest) {
     EmployeeResignation   employeeResignation =
                this.employeeResignationService.createEmployeeResignation(resignationRequest);
        return ResponseEntity.ok(employeeResignation);
    }
    @RequestMapping(value = "api/employee-resignations/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployeeResignationById(@PathVariable Long id) {
        Optional<EmployeeResignation> employeeResignation =
                this.employeeResignationService.getEmployeeResignationById(id);
        return ResponseEntity.of(employeeResignation);
    }

    @RequestMapping(value = "api/employee-resignations/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployeeResignation(
            @PathVariable Long id,
            @RequestBody @Valid ResignationRequest employeeResignation
    ) {
        Optional<EmployeeResignation> employeeResignation1 =
                this.employeeResignationService.updateEmployeeResignation(id, employeeResignation);
        return ResponseEntity.of(employeeResignation1);
    }

    @RequestMapping(value = "api/employee-resignations/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeEmployeeResignation(@PathVariable Long id) {
        this.employeeResignationService.removeEmployeeResignation(id);
        return ResponseEntity.ok("Resignation removed");
    }

}
