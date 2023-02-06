package com.ninjaone.rmm.services.application.create;

import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.ServiceMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class ServiceCreatorShould extends ServicesModuleUnitTestCase {

    private ServiceCreator subject;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new ServiceCreator(serviceRepository);
    }
    @Test
    void create_valid_service() {
        var service = ServiceMother.random();

        subject.create(service.id(), service.name(), 20);

        shouldHaveSaved(service);
    }
}
