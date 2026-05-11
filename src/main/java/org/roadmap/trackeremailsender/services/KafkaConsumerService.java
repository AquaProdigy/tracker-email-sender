package org.roadmap.trackeremailsender.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.roadmap.trackeremailsender.dto.EmailLetterModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {
    private final EmailSenderService emailSenderService;


    @KafkaListener(topics = "${kafka.topic}", concurrency = "${kafka.consumer.concurrency:5}")
    public void listen(EmailLetterModel emailLetterModel) {
        emailSenderService.sendLetterToEmail(emailLetterModel);
        log.info("Got a kafka message - {}", emailLetterModel);
    }
}
