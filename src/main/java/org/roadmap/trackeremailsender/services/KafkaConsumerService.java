package org.roadmap.trackeremailsender.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roadmap.trackeremailsender.models.EmailLetterModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {
    private static final String CONCURRENCY_FOR_KAFKA = "5";
    private final EmailSenderService emailSenderService;


    @KafkaListener(topics = "${kafka.topic}", concurrency = CONCURRENCY_FOR_KAFKA)
    public void listen(EmailLetterModel emailLetterModel) {
        log.info("Got a kafka message - {}", emailLetterModel);

        emailSenderService.sendLetterToEmail(emailLetterModel);
    }
}
