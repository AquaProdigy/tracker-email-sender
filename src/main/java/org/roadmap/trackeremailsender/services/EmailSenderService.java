package org.roadmap.trackeremailsender.services;

import org.roadmap.trackeremailsender.models.EmailLetterModel;

public interface EmailSenderService {
    void sendLetterToEmail(EmailLetterModel emailLetterModel);
}
