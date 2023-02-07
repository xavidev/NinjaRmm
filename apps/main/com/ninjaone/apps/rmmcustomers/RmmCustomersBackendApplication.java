package com.ninjaone.apps.rmmcustomers;

import com.ninjaone.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ninjaone.rmmcustomers.*")
@EntityScan("com.ninjaone.rmmcustomers.*")
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"com.ninjaone.apps.rmmcustomers", "com.ninjaone.rmmcustomers", "com.ninjaone.shared"})
public class RmmCustomersBackendApplication {
}
