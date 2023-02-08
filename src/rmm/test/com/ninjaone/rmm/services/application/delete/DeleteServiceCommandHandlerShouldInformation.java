package com.ninjaone.rmm.services.application.delete;

import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.ServiceMother;
import com.ninjaone.rmm.services.domain.model.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteServiceCommandHandlerShould extends ServicesModuleUnitTestCase {

    private ServiceDeleter subject;
    private DeleteServiceCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new ServiceDeleter(serviceRepository);
        handler = new DeleteServiceCommandHandler(subject);
    }

    @Test
    void delete_a_service() {
        Service service = ServiceMother.random();

        shouldSearch(service);

        handler.handle(new DeleteServiceCommand(service.id()));

        shouldDelete(service);
    }

    @Test
    void not_delete_not_existent_service() {
        Service service = ServiceMother.random();

        handler.handle(new DeleteServiceCommand(service.id()));

        shouldNotDelete(service);
    }
}
