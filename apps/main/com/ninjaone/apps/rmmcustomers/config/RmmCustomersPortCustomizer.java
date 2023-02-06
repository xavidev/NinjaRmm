package com.ninjaone.apps.rmmcustomers.config;

import com.ninjaone.shared.infrastructure.configuration.ConfigurationNotExist;
import com.ninjaone.shared.infrastructure.configuration.ConfigurationParam;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public final class RmmCustomersPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    private final ConfigurationParam configurationParam;

    public RmmCustomersPortCustomizer(ConfigurationParam configurationParam) {
        this.configurationParam = configurationParam;
    }

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        try {
            factory.setPort(configurationParam.getInt("RMMCUSTOMERS_SERVER_PORT"));
        } catch (ConfigurationNotExist parameterNotExist) {
            parameterNotExist.printStackTrace();
        }
    }
}
