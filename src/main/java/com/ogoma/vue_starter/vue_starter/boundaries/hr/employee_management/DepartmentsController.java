package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.entities.Department;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.services.DepartmentsService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

@Controller
public class DepartmentsController {
    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @RequestMapping(value = "api/departments", method = RequestMethod.GET)
    public ResponseEntity<?> getDepartments(PagedDataRequest pagedDataRequest) {
        Page<Department> departments = this.departmentsService.getDepartments(pagedDataRequest);
        return ResponseEntity.ok(departments);
    }

    @RequestMapping(value = "api/departments/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = this.departmentsService.getDepartmentById(id);
        return ResponseEntity.of(department);
    }

    @RequestMapping(value = "api/departments", method = RequestMethod.POST)
    public ResponseEntity<?> createDepartment(@Vali @RequestBody Department department) {
        department = this.departmentsService.createDepartment(department);
        return ResponseEntity.ok(department);
    }

    @RequestMapping(value = "api/departments/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDepartment(@PathVariable Long id,@Valid @RequestBody Department department) {
        Optional<Department> updatedDepartment = this.departmentsService.updateDepartment(id, department);
        return ResponseEntity.of(updatedDepartment);
    }

    @RequestMapping(value = "api/departments/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> removeDepartment(@PathVariable Long id){
        this.departmentsService.removeDepartment(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "api/departments/excel-reports",method = RequestMethod.GET)
    public ResponseEntity<?> getDepartmentsReport() throws IOException {
        ByteArrayInputStream byteArrayInputStream=  this.departmentsService.generateReport();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=departments-report.xlsx");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }
}
