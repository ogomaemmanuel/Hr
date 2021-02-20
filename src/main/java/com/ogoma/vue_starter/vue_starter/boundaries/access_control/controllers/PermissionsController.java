package com.ogoma.vue_starter.vue_starter.boundaries.access_control.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Permission;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.PermissionsRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.PermissionsService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class PermissionsController {
    private final PermissionsService permissionsService;
    public PermissionsController(PermissionsService permissionsService) {
        this.permissionsService = permissionsService;
    }
    @RequestMapping(value = "api/permissions", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(PagedDataRequest pagedDataRequest) {
        Page<Permission> permissions =
                this.permissionsService.getAllPermissions(pagedDataRequest);
        return ResponseEntity.ok(permissions);
    }
    @RequestMapping(value = "api/permissions/excel-report")
    public ResponseEntity<?> getExcelReport() throws IOException {
        ByteArrayInputStream byteArrayInputStream = this.permissionsService.generateReport();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=permissions-report.xlsx");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }
}
