package com.ogoma.vue_starter.vue_starter.utils.mail;

import javax.mail.MessagingException;

public interface MailSender {

    void sendMail(EmailModel emailModel) throws MessagingException;

}
