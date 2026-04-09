package org.roadmap.trackeremailsender;

import org.roadmap.trackeremailsender.services.EmailSenderService;
import org.roadmap.trackeremailsender.services.impl.MailTrapEmailSenderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackerEmailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackerEmailSenderApplication.class, args);
    }

}
