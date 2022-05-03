package com.ogoma.hr_core.boundaries.access_control.controllers;

import com.ogoma.hr_core.boundaries.access_control.entities.Role;
import com.ogoma.hr_core.boundaries.access_control.services.RolesService;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
public class RolesController {
    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("api/roles")
    public ResponseEntity<?> index() {
        List<Role> roles = rolesService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("api/roles/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id) {
        Optional<Role> role = this.rolesService.findRoleById(id);
        return ResponseEntity.of(role);
    }

    @RequestMapping(value = "api/roles-paged", method = RequestMethod.GET)
    public ResponseEntity<?> index(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<Role> roles = rolesService.getAllRoles(pageRequest);
        return ResponseEntity.ok(roles);
    }

    @PostMapping("api/roles")
    public ResponseEntity<?> store(@Valid @RequestBody Role roleRequest) {
        Role role = rolesService.addRole(roleRequest);
        return ResponseEntity.ok(role);
    }

    @RequestMapping(value = "api/roles/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRole(@PathVariable("id") Long id, @Valid @RequestBody Role role) {
        Optional<Role> optionalRole = this.rolesService.updateRole(id, role);
        return ResponseEntity.of(optionalRole);
    }

    @RequestMapping(value = "api/roles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeRole(@PathVariable("id") Long id) {
        this.rolesService.removeRole(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "api/roles/excel-report")
    public ResponseEntity<?> getExcelReport() throws IOException {
        ByteArrayInputStream byteArrayInputStream = this.rolesService.generateReport();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=roles-report.xlsx");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }
}
