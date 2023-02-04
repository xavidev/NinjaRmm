package com.ninjaone.shared.infrastructure.configuration;

import com.ninjaone.shared.domain.Service;
import io.github.cdimascio.dotenv.Dotenv;

@Service
public class ConfigurationParam {
    private final Dotenv dotenv;

    public ConfigurationParam(Dotenv dotenv) {

        this.dotenv = dotenv;
    }

    public String get(String key) throws ConfigurationNotExist {
        String value = dotenv.get(key);

        if (null == value) {
            throw new ConfigurationNotExist(key);
        }

        return value;
    }

    public Integer getInt(String key) throws ConfigurationNotExist {
        String value = get(key);

        return Integer.parseInt(value);
    }
}
