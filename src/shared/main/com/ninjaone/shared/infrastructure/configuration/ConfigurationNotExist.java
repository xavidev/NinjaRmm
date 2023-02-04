package com.ninjaone.shared.infrastructure.configuration;

public class ConfigurationNotExist extends Exception {
    public ConfigurationNotExist(String configKey) {
        super(String.format("The parameter <%s> does not exist in the environment file", configKey));
    }
}
