package com.ogoma.vue_starter.vue_starter.boundaries.access_control.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Permission;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.PermissionsRepository;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PermissionsController {
    private final PermissionsRepository permissionsRepository;
    public PermissionsController(PermissionsRepository permissionsRepository) {
        this.permissionsRepository = permissionsRepository;
    }
    @RequestMapping(value = "api/permissions", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest =
                PageRequest.of(pagedDataRequest.getPage(),
                        pagedDataRequest.getPageSize());
        Page<Permission> permissions = this.permissionsRepository.findAll(pageRequest);
        return ResponseEntity.ok(permissions);
    }
}
