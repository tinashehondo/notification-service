package uk.co.tinashehondo.microservice.notifications.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;

public interface EmailRepository extends CrudRepository<Email, Long> {
    Email findByReferenceId(final String referenceId);
}
