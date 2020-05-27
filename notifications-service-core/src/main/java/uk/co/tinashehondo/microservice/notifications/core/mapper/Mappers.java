package uk.co.tinashehondo.microservice.notifications.core.mapper;

/**
 * Collection of all mapper singleton instances.
 */
public final class Mappers {

    public static final EmailMapper EMAIL_MAPPER = org.mapstruct.factory.Mappers.getMapper(EmailMapper.class);

    private Mappers() {
    }

}
