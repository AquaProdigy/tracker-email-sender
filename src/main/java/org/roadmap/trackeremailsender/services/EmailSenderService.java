package org.roadmap.trackeremailsender.services;

import org.roadmap.trackeremailsender.dto.EmailLetterModel;

public interface EmailSenderService {
    void sendLetterToEmail(EmailLetterModel emailLetterModel);
}
