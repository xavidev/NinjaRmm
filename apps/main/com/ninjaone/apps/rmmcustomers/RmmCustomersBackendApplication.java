package com.ninjaone.apps.rmmcustomers;

import com.ninjaone.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {
        "com.ninjaone.shared",
        "com.ninjaone.rmmcustomers",
        "com.ninjaone.apps.rmmcustomers",
        "com.ninjaone.rmm" })
public class RmmCustomersBackendApplication {
}
