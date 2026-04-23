package org.roadmap.trackeremailsender.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roadmap.trackeremailsender.models.EmailLetterModel;
import org.roadmap.trackeremailsender.services.EmailSenderService;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GmailEmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender javaMailSender;

    @Override
    public void sendLetterToEmail(EmailLetterModel emailLetterModel) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailLetterModel.email());
            message.setSubject(emailLetterModel.title());
            message.setText(emailLetterModel.description());
            javaMailSender.send(message);
        } catch (MailException e) {
            log.error("Error while sending email to email - {} - {}", e.getMessage(), e.getStackTrace());
        }
    }
}
