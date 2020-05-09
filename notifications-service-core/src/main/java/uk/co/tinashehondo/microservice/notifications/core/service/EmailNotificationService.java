package uk.co.tinashehondo.microservice.notifications.core.service;

import uk.co.tinashehondo.notifications.rest.model.Email;
import uk.co.tinashehondo.notifications.rest.model.EmailResponse;

public interface EmailNotificationService {
    EmailResponse sendEmailNotification(final Email email);
}
