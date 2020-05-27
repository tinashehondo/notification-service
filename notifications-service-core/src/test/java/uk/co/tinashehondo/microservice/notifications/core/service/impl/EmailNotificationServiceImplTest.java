package uk.co.tinashehondo.microservice.notifications.core.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thymeleaf.context.Context;
import uk.co.tinashehondo.microservice.notifications.core.mapper.EmailResponseMapper;
import uk.co.tinashehondo.microservice.notifications.core.mapper.Mappers;
//import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;

import uk.co.tinashehondo.notification.rest.model.Email;
import uk.co.tinashehondo.microservice.notifications.domain.repositories.EmailRepository;
import uk.co.tinashehondo.notification.rest.model.EmailResponse;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class EmailNotificationServiceImplTest {
@Mock
private EmailRepository emailRepository;
@Mock
private EmailResponseMapper emailResponseMapper;
@Mock
private EmailSenderServiceImpl emailSenderService;

@InjectMocks
EmailNotificationServiceImpl emailNotificationService;
    @Test
    void sendEmailNotification() throws MessagingException {
      //Train mock
        when(emailRepository.save(any(uk.co.tinashehondo.microservice.notifications.domain.entities.Email.class))).thenReturn(getSavedEmail());
        doNothing().when(emailSenderService).sendEmail(isA(uk.co.tinashehondo.microservice.notifications.domain.entities.Email.class));
        when(emailResponseMapper.apply(isA(uk.co.tinashehondo.microservice.notifications.domain.entities.Email.class))).thenReturn(getTestEmailResponse());

        //Act
        EmailResponse emailResponse = emailNotificationService.sendEmailNotification(getTestEmail());

        //Verify
        verify(emailSenderService, times(1)).sendEmail(isA(uk.co.tinashehondo.microservice.notifications.domain.entities.Email.class));
        verify(emailRepository, times(1)).save((any(uk.co.tinashehondo.microservice.notifications.domain.entities.Email.class)));
        Assert.assertEquals(emailResponse.getMessage(),getTestEmail().getMessage());

    }


    private Email getTestEmail() {
        Email email = new Email();
        email.setSubject("123");
        email.setMessage("hie");
        email.setReceiver("TestReceiver");
        email.setNotificationType("EMAIL");
        email.setSender("TestSender");
        return email;
    }

    private uk.co.tinashehondo.microservice.notifications.domain.entities.Email getSavedEmail(){
        uk.co.tinashehondo.microservice.notifications.domain.entities.Email savedEmail = new uk.co.tinashehondo.microservice.notifications.domain.entities.Email();
        savedEmail.setReferenceId("REF");
        savedEmail.setId("TestID");
        savedEmail.setSubject("123");
        savedEmail.setReceiver("TestReceiver");
        savedEmail.setSender("TestSender");
        savedEmail.setMessage("hie");
        return savedEmail;
    }


    private EmailResponse getTestEmailResponse(){
        EmailResponse emailResponse = new EmailResponse();
        emailResponse.setSubject("123");
        emailResponse.setMessage("hie");
        emailResponse.setReceiver("TestReceiver");
        emailResponse.setNotificationType("EMAIL");
        emailResponse.setSender("TestSender");

        return emailResponse;
    }



}