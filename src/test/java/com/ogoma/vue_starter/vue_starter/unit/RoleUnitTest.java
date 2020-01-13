package com.ogoma.vue_starter.vue_starter.unit;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.RolesRepository;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.RolesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class RoleUnitTest {
    @InjectMocks
    //The class we wish to test
    private RolesService rolesService;
    @Mock
    //will be injected/autowired to field with @InjectMocks/the class being tested
    // A mock is just a fake class
    private RolesRepository rolesRepository;

    @Test
    public void userCanAddNewRole() {
       //setup: create role
        Role role = new Role("test","test");
        //when save method of mock class is called return role we created above
        when(rolesRepository.save(any(Role.class))).thenReturn(role);
        //call the method we are testing
        rolesService.addRole(role);
        //verify if save has been called
        verify(rolesRepository, times(1))
                .save(any(Role.class));
    }
}
