package uk.co.tinashehondo.microservice.notifications.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Sms;

public interface SmsRepository extends CrudRepository<Sms, Long> {
Sms findByReferenceId(final String referenceId);
}
