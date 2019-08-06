package com.ogoma.vue_starter.vue_starter.utils.mail;

import com.ogoma.vue_starter.vue_starter.utils.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Component
public class SmtpMailSender implements MailSender {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;
    public void sendMail(EmailModel emailModel) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        Context context = new Context();
        context.setVariables(emailModel.getTemplateVariable());
        String html = templateEngine.process("mail"+emailModel.getTemplatePath(), context);
        helper.setTo(emailModel.getTo());
        helper.setFrom("ogoma.emmanuel@gmail.com");
        helper.setSubject(emailModel.getSubject());
        if (emailModel.isHtml()) {
            helper.setText(html, true);
        } else {
            helper.setText(emailModel.getText(), true);
        }
        javaMailSender.send(msg);

    }
}
