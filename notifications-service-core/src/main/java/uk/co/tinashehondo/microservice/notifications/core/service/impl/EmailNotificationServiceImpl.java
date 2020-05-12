package uk.co.tinashehondo.microservice.notifications.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.co.tinashehondo.microservice.notifications.core.mapper.EmailResponseMapper;
import uk.co.tinashehondo.microservice.notifications.core.mapper.Mappers;
import uk.co.tinashehondo.microservice.notifications.core.service.EmailNotificationService;
import uk.co.tinashehondo.microservice.notifications.domain.repositories.EmailRepository;
import uk.co.tinashehondo.notifications.rest.model.Email;
import uk.co.tinashehondo.notifications.rest.model.EmailResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailNotificationServiceImpl implements EmailNotificationService {
    private final EmailRepository emailRepository;
    private final EmailResponseMapper emailResponseMapper;
    @Override
    public EmailResponse sendEmailNotification(final Email email) {
        final uk.co.tinashehondo.microservice.notifications.domain.entities.Email domainEmail = Mappers.EMAIL_MAPPER.dtoToDomain(email);
        final uk.co.tinashehondo.microservice.notifications.domain.entities.Email savedEmail = emailRepository.save(domainEmail);

        //TODO impl sender
        return emailResponseMapper.apply(savedEmail) ;
    }


}
