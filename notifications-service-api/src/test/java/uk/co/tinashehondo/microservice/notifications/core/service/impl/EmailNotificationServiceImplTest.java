package uk.co.tinashehondo.microservice.notifications.core.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.co.tinashehondo.microservice.notifications.core.mapper.EmailResponseMapper;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;
import uk.co.tinashehondo.microservice.notifications.domain.repositories.EmailRepository;
import uk.co.tinashehondo.notifications.rest.model.EmailResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
class EmailNotificationServiceImplTest {
@Mock
private EmailRepository emailRepository;
@Mock
private EmailResponseMapper emailResponseMapper;


@InjectMocks
private EmailNotificationServiceImpl emailNotificationServiceImpl;

    @Test
    void sendEmailNotification() {
        Email savedEmail =Email.builder()
                .message("test msg")
                .receiver("receiver@gmail.com")
                .sender("sender@gmail.com")
                .referenceId("REF001")
                .subject("Activation")
                .id("123xyz")
                .build();
        EmailResponse emailResponse = new  EmailResponse();
        emailResponse.referenceId(savedEmail.getReferenceId());
        emailResponse.subject(savedEmail.getSubject());
        emailResponse.receiver(savedEmail.getReceiver());
        emailResponse.message(savedEmail.getMessage());

        //train or mock
        when(emailRepository.save(any())).thenReturn(savedEmail);
        when(emailResponseMapper.apply(any())).thenReturn(emailResponse);
       //when(emailMapper.dtoToDomain(any())).thenReturn(new Email());
        uk.co.tinashehondo.notifications.rest.model.Email emailRequest = new uk.co.tinashehondo.notifications.rest.model.Email();
        emailRequest.sender(savedEmail.getSender());
        emailRequest.receiver(savedEmail.getReceiver());
        //act
        EmailResponse response = emailNotificationServiceImpl.sendEmailNotification(emailRequest);

        //verify
        Assert.assertNotNull(response);


    }
}
