package com.ogoma.vue_starter.vue_starter.integration;

import com.ogoma.vue_starter.vue_starter.VueStarterApplication;
import com.ogoma.vue_starter.vue_starter.controllers.AuthController;
import com.ogoma.vue_starter.vue_starter.utils.mail.EmailModel;
import com.ogoma.vue_starter.vue_starter.utils.mail.MailSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VueStarterApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AuthControllerIntegrationTest {
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    @Autowired
    AuthController authController;
    @MockBean
    MailSender mailSender;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        doNothing().when(mailSender).sendMail(any(EmailModel.class));
        this.mockMvc = standaloneSetup(this.authController).build();
        // this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test_can_register_a_user() throws Exception {
        this.mockMvc.perform(post("/register")
                .with(csrf().asHeader()).secure(true).contentType(CONTENT_TYPE)
                .content("{\n" +
                        "\t\"email\":\"ogoma.emmanuel21@gmail.com\",\n" +
                        "\t\"password\":\"123456\",\n" +
                        "\t\"confirmPassword\":\"123456\",\n" +
                        "\t\"firstName\":\"Emmanuel\",\n" +
                        "\t\"lastName\":\"ogoma\",\n" +
                        "\t\"phone\":\"0711472504\"\n" +
                        "}")
        ).andDo(print()).andExpect(status().isOk());
        //verify(mailSender, times(1)).sendMail(any(EmailModel.class));
    }
    @Test
    public void test_a_user_can_submit_forgot_password_request() throws Exception {
        this.mockMvc.perform(post("/forgot-password")
                .with(csrf().asHeader()).secure(true).contentType(CONTENT_TYPE)
                .content("{\n" +
                        "\t\"email\":\"ogoma.emmanuel+55@gmail.com\"\n" +
                        "\n" +
                        "}")
        ).andDo(print()).andExpect(status().isOk());
        verify(mailSender, times(1)).sendMail(any(EmailModel.class));
    }
}
