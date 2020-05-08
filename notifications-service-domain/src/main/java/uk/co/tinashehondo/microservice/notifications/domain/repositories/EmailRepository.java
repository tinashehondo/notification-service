package uk.co.tinashehondo.microservice.notifications.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;

import java.util.List;

public interface EmailRepository extends CrudRepository<Email, Long> {

    Email getNotificationsEmailByReferenceId(String referenceId);
    List<Email> getNotificationsEmail();

}
