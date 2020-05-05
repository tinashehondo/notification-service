package uk.co.tinashehondo.microservice.notifications.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties("app")
@Validated
@Getter
@Setter
public class ApplicationProperties {

}
