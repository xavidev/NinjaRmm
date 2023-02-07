package com.ninjaone.rmm.services;

import com.ninjaone.apps.rmm.RmmBackendApplication;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = RmmBackendApplication.class)
@SpringBootTest
public abstract class ServicesModuleInfrastructureTestCase {

    @Autowired
    protected ServiceRepository mySqlCourseRepository;
}
