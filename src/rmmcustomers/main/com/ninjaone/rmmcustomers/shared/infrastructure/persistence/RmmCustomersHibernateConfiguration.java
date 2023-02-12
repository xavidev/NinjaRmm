package com.ninjaone.rmmcustomers.shared.infrastructure.persistence;

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
public class RmmCustomersHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final ConfigurationParam config;
    private final String CONTEXT_NAME = "rmmcustomers";


    public RmmCustomersHibernateConfiguration(HibernateConfigurationFactory factory, ConfigurationParam config) {
        this.factory = factory;
        this.config = config;
    }

    @Bean(name = "rmmcustomers-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ConfigurationNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean(name="rmmcustomers-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ConfigurationNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("rmmcustomers-data_source")
    public DataSource dataSource() throws IOException, ConfigurationNotExist {
        return factory.dataSource(
            config.get("RMMCUSTOMERS_DATABASE_HOST"),
            config.getInt("RMMCUSTOMERS_DATABASE_PORT"),
            config.get("RMMCUSTOMERS_DATABASE_NAME"),
            config.get("RMMCUSTOMERS_DATABASE_USER"),
            config.get("RMMCUSTOMERS_DATABASE_PASSWORD")
        );
    }
}
