package com.ogoma.vue_starter.vue_starter.unit;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.RolesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class RoleUnitTest {
    @Resource
    private RolesService rolesService;

    @Test
    public void userCanAddNewRole() {
        Role role = new Role("Admin", "System Admin");

        rolesService.addRole(role);

        Optional<Role> newlyAddedRole = rolesService.findRoleById(role.getId());

        assertEquals(newlyAddedRole.get().getName(), "Admin");
    }
}
