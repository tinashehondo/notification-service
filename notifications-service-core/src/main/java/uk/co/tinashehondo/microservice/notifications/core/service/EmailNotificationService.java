package uk.co.tinashehondo.microservice.notifications.core.service;

import uk.co.tinashehondo.notification.rest.model.Email;
import uk.co.tinashehondo.notification.rest.model.EmailResponse;

public interface EmailNotificationService {
    EmailResponse sendEmailNotification(final Email email);
}
