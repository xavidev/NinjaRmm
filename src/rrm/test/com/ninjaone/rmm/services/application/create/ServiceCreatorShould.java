package com.ninjaone.rmm.services.application.create;

import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.DeviceServiceMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class ServiceCreatorShould extends ServicesModuleUnitTestCase {

    private ServiceCreator subject;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new ServiceCreator(repository);
    }
    @Test
    void create_valid_service() {
        var service = DeviceServiceMother.random();

        subject.create(service.id(), service.name());

        shouldHaveSaved(service);
    }
}
