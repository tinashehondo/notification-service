package uk.co.tinashehondo.microservice.notifications.core.service.impl;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class EmailSenderServiceTest {
    @Mock
    private JavaMailSender javaMailSender;
    @Mock
    private ITemplateEngine templateEngine;
    @Mock
    MimeMessage mimeMessage;
    @InjectMocks
    EmailSenderService emailSenderService;

    @Test
    public void sendEmailTest() throws MessagingException {
        //Train our mock
        doNothing().when(javaMailSender).send(isA(MimeMessage.class));
        when(javaMailSender.createMimeMessage()).thenReturn(mimeMessage);
        when(templateEngine.process(isA(String.class), isA(Context.class))).thenReturn("test");

        //Act
        emailSenderService.sendEmail(getTestEmail());

        //Verify
        verify(javaMailSender, times(1)).send(isA(MimeMessage.class));
        verify(javaMailSender, times(1)).createMimeMessage();
        verify(templateEngine, times(1)).process(isA(String.class), isA(Context.class));
    }

    private Email getTestEmail() {
        return Email.builder()
                .id("123")
                .message("hie")
                .receiver("Charmaine")
                .referenceId("REF001")
                .sender("Tinashe")
                .subject("test")
                .build();
    }

}