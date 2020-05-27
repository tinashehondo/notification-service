package uk.co.tinashehondo.microservice.notifications.core.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import org.thymeleaf.ITemplateEngine;

import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service

@RequiredArgsConstructor
public class EmailSenderService {

  private final JavaMailSender javaMailSender;

  private final ITemplateEngine templateEngine;


  @Async
  public void sendEmail(Email email) throws MessagingException {
    MimeMessage message = getMimeMessage(email);
    javaMailSender.send(message);
  }

  private MimeMessage getMimeMessage(Email mail) throws MessagingException {
    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper =
        new MimeMessageHelper(
            message,
            MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
            StandardCharsets.UTF_8.name());

    Context context = new Context();
    Map<String, Object> model = new HashMap<>();
    model.put("message",  mail.getMessage());
    context.setVariables(model);
    String html = templateEngine.process("email-template", context);

    helper.setTo(mail.getReceiver());
    helper.setText(html, true);
    helper.setSubject(mail.getSubject());
    helper.setFrom(mail.getSender());
    return message;
  }
}
