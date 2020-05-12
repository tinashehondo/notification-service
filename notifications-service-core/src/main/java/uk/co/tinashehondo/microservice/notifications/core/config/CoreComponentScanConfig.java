package uk.co.tinashehondo.microservice.notifications.core.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import uk.co.tinashehondo.microservice.notifications.domain.DomainRoot;


@Configuration
@EnableJpaRepositories(basePackageClasses = DomainRoot.class)
@EntityScan(basePackageClasses = DomainRoot.class)
public class CoreComponentScanConfig {
}
