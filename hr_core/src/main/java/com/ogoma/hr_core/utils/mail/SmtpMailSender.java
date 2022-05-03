package com.ogoma.hr_core.utils.mail;

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
    private final String TEMPLATE_BASE_PATH = "mail";
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendMail(EmailModel emailModel) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(emailModel.getTo());
        helper.setFrom("ogoma.emmanuel@hotmail.com");
        helper.setSubject(emailModel.getSubject());
        if (emailModel.isHtml()) {
            Context context = new Context();
            context.setVariables(emailModel.getTemplateVariable());
            String html = templateEngine.process(TEMPLATE_BASE_PATH + emailModel.getTemplatePath(), context);
            helper.setText(html, true);
        } else {
            helper.setText(emailModel.getText(), false);
        }
        javaMailSender.send(msg);

    }
}
