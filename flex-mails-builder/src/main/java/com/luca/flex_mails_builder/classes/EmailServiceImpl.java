package com.luca.flex_mails_builder.classes;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendEmail(String to, String subject, String bodyText) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setFrom("no@reply.com");
        message.setText(bodyText);
        message.setSubject(subject);

        mailSender.send(message);
    }
}
