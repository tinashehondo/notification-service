package uk.co.tinashehondo.microservice.notifications.core.mapper;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;
import uk.co.tinashehondo.notification.rest.model.EmailResponse;

@ExtendWith(SpringExtension.class)
public class EmailResponseMapperTest {
@InjectMocks
private EmailResponseMapper emailResponseMapper;

    @Test
    void apply() {
        Email email = Email.builder()
                .id("123")
                .message("hie")
                .receiver("Charmaine")
                .referenceId("REF001")
                .sender("Tinashe")
                .subject("test")
                .build();

        EmailResponse emailResponse = emailResponseMapper.apply(email);
        Assert.assertEquals(emailResponse.getReferenceId(),email.getReferenceId());
        Assert.assertNotNull(emailResponse);
        Assert.assertEquals(emailResponse.getMessage(), email.getMessage());
    }

}
