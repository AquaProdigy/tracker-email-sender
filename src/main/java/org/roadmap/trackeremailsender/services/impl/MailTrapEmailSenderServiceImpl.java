package org.roadmap.trackeremailsender.services.impl;

import io.mailtrap.client.MailtrapClient;
import io.mailtrap.model.request.emails.Address;
import io.mailtrap.model.request.emails.MailtrapMail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roadmap.trackeremailsender.models.EmailLetterModel;
import org.roadmap.trackeremailsender.services.EmailSenderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailTrapEmailSenderServiceImpl implements EmailSenderService {
    private final MailtrapClient client;

    @Override
    public void sendLetterToEmail(EmailLetterModel emailLetterModel) {
        try {
            MailtrapMail mailtrapMail = buildMailForSend(emailLetterModel);
            client.send(mailtrapMail);
        } catch (Exception e) {
            log.error("Send email error - {}", e.getMessage());
        }
    }

    private MailtrapMail buildMailForSend(EmailLetterModel emailLetterModel) {
        return MailtrapMail.builder()
                .from(new Address("hello@demomailtrap.co", "Mailtrap Test"))
                .to(List.of(new Address(emailLetterModel.email())))
                .subject(emailLetterModel.title())
                .text(emailLetterModel.description())
                .build();
    }

}
