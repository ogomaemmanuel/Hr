package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Designation;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models.DesignationUpdateRequest;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.DesignationService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class DesignationsController {
    private final DesignationService designationService;

    public DesignationsController(DesignationService designationService) {
        this.designationService = designationService;
    }

    @RequestMapping(value = "api/designations", method = RequestMethod.GET)
    public ResponseEntity<?> getAllDesignations(PagedDataRequest pagedDataRequest) {
        Page<Designation> designations = this.designationService.getDesignations(pagedDataRequest);
        return ResponseEntity.ok(designations);
    }

    @RequestMapping(value = "api/designations/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDesignationsById(@PathVariable Long id) {
        Optional<Designation> designation = this.designationService.getDesignationById(id);
        return ResponseEntity.of(designation);
    }

    @RequestMapping(value = "api/designations", method = RequestMethod.POST)
    public ResponseEntity<?> createDesignation(Designation designation) {
        designation = this.designationService.createDesignation(designation);
        return ResponseEntity.ok(designation);
    }

    @RequestMapping(value = "api/designations/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDesignation(@PathVariable Long id, DesignationUpdateRequest designation) {
        Optional<Designation> designationUpdate = this.designationService.updateDesignation(id, designation);
        return ResponseEntity.of(designationUpdate);
    }
}