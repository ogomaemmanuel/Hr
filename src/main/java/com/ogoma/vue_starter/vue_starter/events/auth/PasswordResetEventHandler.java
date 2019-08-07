package com.ogoma.vue_starter.vue_starter.events.auth;

import com.ogoma.vue_starter.vue_starter.controllers.AuthController;
import com.ogoma.vue_starter.vue_starter.entities.PasswordReset;
import com.ogoma.vue_starter.vue_starter.utils.mail.EmailModel;
import com.ogoma.vue_starter.vue_starter.utils.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Component
public class PasswordResetEventHandler {
    @Autowired
    private MailSender mailSender;
    @EventListener
    private void handleEvent(PasswordResetEvent passwordResetEvent){
        Map<String, Object> emailTemplateVariables = new HashMap<>();
        emailTemplateVariables.put("username", passwordResetEvent.getPasswordReset().getUser().getFirstName());
        EmailModel emailModel = new EmailModel();
        emailModel.setSubject("Password reset");
        emailModel.setHtml(true);
        emailModel.setTo(passwordResetEvent.getPasswordReset().getUser().getEmail());
        emailModel.setTemplateVariable(emailTemplateVariables);
        emailModel.setTemplatePath("/password_reset");
        UriComponentsBuilder base = ServletUriComponentsBuilder.fromCurrentContextPath().path("/");

        String url = MvcUriComponentsBuilder.relativeTo(base).fromMethodName(AuthController.class, "resetPassword", passwordResetEvent.getPasswordReset().getUser().getId(), passwordResetEvent.getPasswordReset().getToken(),new Object()).build().toString();
        emailTemplateVariables.put("link",url);
        try {
            this.mailSender.sendMail(emailModel);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
