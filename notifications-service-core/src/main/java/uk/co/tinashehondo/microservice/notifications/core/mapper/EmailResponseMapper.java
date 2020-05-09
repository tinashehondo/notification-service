package uk.co.tinashehondo.microservice.notifications.core.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;
import uk.co.tinashehondo.notifications.rest.model.EmailResponse;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class EmailResponseMapper implements Function<Email, EmailResponse> {
    @Override
    public EmailResponse apply(Email email) {
        final EmailResponse emailResponse = new EmailResponse();
        emailResponse.sender(email.getSender());
        emailResponse.message(email.getMessage());
        emailResponse.receiver(email.getReceiver());
        emailResponse.referenceId(email.getReferenceId());
        emailResponse.subject(email.getSubject());
        return emailResponse;
    }
}
