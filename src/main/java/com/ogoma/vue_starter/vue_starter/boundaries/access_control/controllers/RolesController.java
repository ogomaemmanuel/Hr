package com.ogoma.vue_starter.vue_starter.boundaries.access_control.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.RolesRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping("api/roles")
    public ResponseEntity<?> store(@RequestBody Role roleRequest) {
        Role role = rolesService.addRole(roleRequest);

        return  ResponseEntity.ok(role);
    }
}
