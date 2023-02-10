package com.ninjaone.rmm.services.application.delete;

import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.ServiceMother;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteServiceCommandHandlerShouldInformation extends ServicesModuleUnitTestCase {

    private ServiceDeleter subject;
    private DeleteServiceCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new ServiceDeleter(serviceInformationRepository);
        handler = new DeleteServiceCommandHandler(subject);
    }

    @Test
    void delete_a_service() {
        ServiceInformation serviceInformation = ServiceMother.random();

        shouldSearch(serviceInformation);

        handler.handle(new DeleteServiceCommand(serviceInformation.id()));

        shouldDelete(serviceInformation);
    }

    @Test
    void not_delete_not_existent_service() {
        ServiceInformation serviceInformation = ServiceMother.random();

        handler.handle(new DeleteServiceCommand(serviceInformation.id()));

        shouldNotDelete(serviceInformation);
    }
}
