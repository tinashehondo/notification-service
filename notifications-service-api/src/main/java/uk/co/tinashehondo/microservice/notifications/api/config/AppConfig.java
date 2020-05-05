package uk.co.tinashehondo.microservice.notifications.api.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import uk.co.tinashehondo.microservice.notifications.core.CoreRoot;

@Configuration
@ComponentScan(basePackageClasses = CoreRoot.class)
@EnableConfigurationProperties(ApplicationProperties.class)
public class AppConfig {
}
