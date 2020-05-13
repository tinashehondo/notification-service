package uk.co.tinashehondo.microservice.notifications.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import uk.co.tinashehondo.microservice.notifications.core.service.EmailNotificationService;
import uk.co.tinashehondo.notification.rest.api.NotificationApi;
import uk.co.tinashehondo.notification.rest.model.Email;
import uk.co.tinashehondo.notification.rest.model.EmailResponse;
//import uk.co.tinashehondo.notification.rest.model.Sms;
//import uk.co.tinashehondo.notification.rest.model.SmsResponse;

import javax.validation.Valid;


@Slf4j
@RestController
@CrossOrigin(origins = CorsConfiguration.ALL)
@RequestMapping("/api/")
@RequiredArgsConstructor
public class EmailNotificationsController implements NotificationApi {

    private final EmailNotificationService emailNotificationService;
//    @Override
//    public ResponseEntity<EmailResponse> getEmailNotification() {
//        return null;
//    }

    @Override
    public ResponseEntity<EmailResponse> sendEmailNotification(@Valid Email email) {
        return ResponseEntity.ok(emailNotificationService.sendEmailNotification(email));
    }

}
