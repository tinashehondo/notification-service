package uk.co.tinashehondo.microservice.notifications.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;

@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
    Email findByReferenceId(final String referenceId);
}
