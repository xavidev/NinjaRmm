package com.ninjaone.apps;

import com.ninjaone.apps.rmm.RmmBackendApplication;
import com.ninjaone.apps.rmmcustomers.RmmCustomersBackendApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;


public class Starter {
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new RuntimeException("There are not enough arguments");
        }

        String  applicationName = args[0];

        ensureApplicationExist(applicationName);

        Class<?> applicationClass = applications().get(applicationName);

        SpringApplication app = new SpringApplication(applicationClass);

        ConfigurableApplicationContext context = app.run(args);

        String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }

    private static void ensureApplicationExist(String applicationName) {
        if (!applications().containsKey(applicationName)) {
            throw new RuntimeException(String.format(
                "The application <%s> doesn't exist. Valids:\n- %s",
                applicationName,
                String.join("\n- ", applications().keySet())
            ));
        }
    }

    private static HashMap<String, Class<?>> applications() {
        HashMap<String, Class<?>> applications = new HashMap<>();

        applications.put("rmm_backend", RmmBackendApplication.class);
        applications.put("rmmcustomers_backend", RmmCustomersBackendApplication.class);

        return applications;
    }
}
