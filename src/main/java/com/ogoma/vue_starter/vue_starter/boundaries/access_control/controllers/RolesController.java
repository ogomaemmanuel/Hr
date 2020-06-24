package com.ogoma.vue_starter.vue_starter.boundaries.access_control.controllers;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.RolesService;
import com.ogoma.vue_starter.vue_starter.models.requests.PagedDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> store(@RequestBody Role roleRequest) {
        Role role = rolesService.addRole(roleRequest);
        return ResponseEntity.ok(role);
    }

    @RequestMapping(value = "api/roles/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRole(@PathVariable("id")Long id ,@RequestBody Role role){
      Optional<Role> optionalRole= this.rolesService.updateRole(id,role);
      return ResponseEntity.of(optionalRole);
    }

    @RequestMapping(value = "api/roles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeRole(@PathVariable("id") Long id) {
        this.rolesService.removeRole(id);
        return ResponseEntity.ok().build();
    }
}
