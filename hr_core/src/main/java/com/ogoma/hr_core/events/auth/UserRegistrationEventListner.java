package com.ogoma.hr_core.events.auth;

import com.ogoma.hr_core.controllers.AuthController;
import com.ogoma.hr_core.utils.mail.EmailModel;
import com.ogoma.hr_core.utils.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;
@Component
public class UserRegistrationEventListner implements ApplicationListener<UserRegistrationEvent> {
    @Autowired
    private MailSender mailSender;
    @Override
    @Async
    public void onApplicationEvent(UserRegistrationEvent event) {
        Map<String, Object> emailTemplateVariables = new HashMap<>();
        emailTemplateVariables.put("username", event.getUser().getFirstName());
        EmailModel emailModel = new EmailModel();
        emailModel.setText("Thanks for registration");
        emailModel.setSubject("Registration successful");
        emailModel.setHtml(true);
        emailModel.setTo(event.getUser().getEmail());
        emailModel.setTemplateVariable(emailTemplateVariables);
        emailModel.setTemplatePath("/registration_successful");
        UriComponentsBuilder base = ServletUriComponentsBuilder.fromCurrentContextPath().path("/");
        String url = MvcUriComponentsBuilder.relativeTo(base).fromMethodName(AuthController.class, "confirmRegistration", event.getUser().getId(), event.getPasswordReset().getToken(),new Object()).build().toString();
        emailTemplateVariables.put("link",url);
        try {
            this.mailSender.sendMail(emailModel);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
