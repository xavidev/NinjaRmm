package com.ninjaone.apps.config;

import com.ninjaone.shared.infrastructure.configuration.ConfigurationNotExist;
import com.ninjaone.shared.infrastructure.configuration.ConfigurationParam;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public final class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    private final ConfigurationParam configurationParam;

    public ServerPortCustomizer(ConfigurationParam configurationParam) {
        this.configurationParam = configurationParam;
    }

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        try {
            factory.setPort(configurationParam.getInt("SERVER_PORT"));
        } catch (ConfigurationNotExist parameterNotExist) {
            parameterNotExist.printStackTrace();
        }
    }
}
