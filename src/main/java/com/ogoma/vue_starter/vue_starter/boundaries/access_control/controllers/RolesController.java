package com.ogoma.vue_starter.vue_starter.boundaries.access_control.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.RolesService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping("api/roles")
    public ResponseEntity<?> index() {
        List<Role> roles = rolesService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
    @RequestMapping(value = "api/roles/paged",method = RequestMethod.GET)
    public ResponseEntity<?> index(PagedDataRequest pagedDataRequest) {
        PageRequest pageRequest = PageRequest.of(pagedDataRequest.getPage(), pagedDataRequest.getPageSize());
        Page<Role> roles = rolesService.getAllRoles(pageRequest);
        return ResponseEntity.ok(roles);
    }

    @PostMapping("api/roles")
    public ResponseEntity<?> store(@RequestBody Role roleRequest) {
        Role role = rolesService.addRole(roleRequest);

        return ResponseEntity.ok(role);
    }
}
