package uk.co.tinashehondo.microservice.notifications.core.mapper;

import org.mapstruct.Mapper;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;

@Mapper
public interface EmailMapper {
    Email dtoToDomain(uk.co.tinashehondo.notification.rest.model.Email email);
    uk.co.tinashehondo.notification.rest.model.Email domainToDto(Email email);
}
