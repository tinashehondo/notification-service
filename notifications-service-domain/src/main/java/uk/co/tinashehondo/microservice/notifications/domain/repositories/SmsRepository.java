package uk.co.tinashehondo.microservice.notifications.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Sms;

import java.util.List;

public interface SmsRepository extends CrudRepository<Sms, Long> {

    Sms getNotificationsSmsByReferenceId(String referenceId);
    List<Sms> getNotificationsSms();

}
