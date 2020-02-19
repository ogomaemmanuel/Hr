package com.ogoma.vue_starter.vue_starter.boundaries.access_control.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.RolesRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.hr.holidays.entities.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public Optional<Role> findRoleById(long id) {
        return rolesRepository.findById(id);
    }

    public List<Role> getAllRoles() {
        List<Role> roles = rolesRepository.findAll();
        return roles;
    }
    public Page<Role> getAllRoles(Pageable pageable) {
        Page<Role> roles = rolesRepository.findAll(pageable);
        return roles;
    }

    public Role addRole(Role roleRequest) {
        return rolesRepository.save(roleRequest);
    }
}
