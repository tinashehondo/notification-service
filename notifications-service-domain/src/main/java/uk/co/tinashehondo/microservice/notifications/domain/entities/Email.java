package uk.co.tinashehondo.microservice.notifications.domain.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Email {
    @Id
    private String id;

    private String sender;

    private String message;

    private String receiver;

    private String referenceId;

    private String subject;
}

