package com.ninjaone.rmm.shared.infrastructure.persistence;

import com.ninjaone.shared.infrastructure.configuration.ConfigurationNotExist;
import com.ninjaone.shared.infrastructure.configuration.ConfigurationParam;
import com.ninjaone.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final ConfigurationParam config;
    private final String CONTEXT_NAME = "rmm";


    public HibernateConfiguration(HibernateConfigurationFactory factory, ConfigurationParam config) {
        this.factory = factory;
        this.config = config;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ConfigurationNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() throws IOException, ConfigurationNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean
    public DataSource dataSource() throws IOException, ConfigurationNotExist {
        return factory.dataSource(
            config.get("DATABASE_HOST"),
            config.getInt("DATABASE_PORT"),
            config.get("DATABASE_NAME"),
            config.get("DATABASE_USER"),
            config.get("DATABASE_PASSWORD")
        );
    }
}
