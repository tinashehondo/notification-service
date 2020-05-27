package uk.co.tinashehondo.microservice.notifications.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.tinashehondo.microservice.notifications.domain.entities.Email;
import uk.co.tinashehondo.microservice.notifications.domain.repositories.EmailRepository;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmailNotificationsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmailRepository emailRepository;

        @Test
        void sendEmailNotification() throws Exception {
        //train our mock
        final Email email = new Email();
        email.setSubject("testSubject");
        email.setMessage("testMessage");
        email.setReceiver("testR@gmail.com");
        email.setSender("testS@gmail.com");
        email.setId("testId");

        when(emailRepository.save(any(Email.class))).thenReturn(email);

        mockMvc.perform(post("/api/notification/email")
                .content(asJsonString(email))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.subject", is("testSubject")))
                .andExpect(jsonPath("$.referenceId", is("testId")));

        verify(emailRepository, times(1)).save(any(Email.class));

    }

        static String asJsonString ( final Object obj){
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
