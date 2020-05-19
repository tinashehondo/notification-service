package uk.co.tinashehondo.microservice.notifications.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import uk.co.tinashehondo.microservice.notifications.core.service.EmailNotificationService;
import uk.co.tinashehondo.notification.rest.api.NotificationApi;
import uk.co.tinashehondo.notification.rest.model.Email;
import uk.co.tinashehondo.notification.rest.model.EmailResponse;

import javax.validation.Valid;


@Slf4j
@RestController
@CrossOrigin(origins = CorsConfiguration.ALL)
@RequestMapping("/api/")
@RequiredArgsConstructor
public class EmailNotificationsController implements NotificationApi {

    private final EmailNotificationService emailNotificationService;

    @Override
    @RequestMapping(value = "notification/email", method = RequestMethod.POST)
    public ResponseEntity<EmailResponse> sendEmailNotification(@Valid Email email) {

        return ResponseEntity.ok(emailNotificationService.sendEmailNotification(email));
    }

}
