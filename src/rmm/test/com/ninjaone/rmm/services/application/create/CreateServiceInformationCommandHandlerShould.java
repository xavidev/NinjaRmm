package com.ninjaone.rmm.services.application.create;

import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateServiceInformationCommandHandlerShould extends ServicesModuleUnitTestCase {

    private CreateServiceCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        ServiceCreator subject = new ServiceCreator(serviceInformationRepository);
        handler = new CreateServiceCommandHandler(subject);
    }
    @Test
    void create_valid_service() {
        var service = ServiceInformationMother.random();

        handler.handle(new CreateServiceCommand(service.id(), service.name(), "20"));

        shouldHaveSaved(service);
    }

}
