package com.ninjaone.rmm.services;

import com.ninjaone.apps.Starter;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Starter.class)
@SpringBootTest
public abstract class ServicesModuleInfrastructureTestCase {

    @Autowired
    protected ServiceRepository mySqlCourseRepository;
}
