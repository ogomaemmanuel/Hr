package com.ogoma.hr_core.utils.mail;

import javax.mail.MessagingException;

public interface MailSender {

    void sendMail(EmailModel emailModel) throws MessagingException;

}
