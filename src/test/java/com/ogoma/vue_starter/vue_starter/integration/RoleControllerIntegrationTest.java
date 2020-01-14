package com.ogoma.vue_starter.vue_starter.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ogoma.vue_starter.vue_starter.VueStarterApplication;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.controllers.RolesController;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.Role;
import com.ogoma.vue_starter.vue_starter.controllers.AuthController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@SpringBootTest(classes = VueStarterApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class RoleControllerIntegrationTest {
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    @Autowired
    MockMvc mockMvc;
    @Autowired
    RolesController rolesController;

    //Used for changing and Object to Json
    ObjectMapper objectMapper = new ObjectMapper();

    @Before// runs before each test method
    public void setup() throws Exception {
       // we just want to test rolesController with it's dependencies
        this.mockMvc = standaloneSetup(this.rolesController).build();
    }

    // creates an authenticated user with user test, without this, there will be
   // a redirect to login since path /api/roles is protected
    @WithMockUser(username = "test")
    @Test
    public void an_authenticated_user_can_create_role() throws Exception {
        Role role = new Role("test", "test");
        mockMvc.perform(
                post("/api/roles", 1)
                        .with(csrf().asHeader()).secure(true).contentType(CONTENT_TYPE)
                        .content(
                                objectMapper.writeValueAsString(role)
                        )
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void user_not_authenticated_cannot_create_role_and_will_be_redirected_to_login() throws Exception {
        Role role = new Role("test", "test");
        mockMvc.perform(
                post("/api/roles", 1)
                        .with(csrf().asHeader()).secure(true).contentType(CONTENT_TYPE)
                        .content(
                                objectMapper.writeValueAsString(role)
                        )
        ).andDo(print()).andExpect(status().is(302));
    }
}
