package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.ServiceMother;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceCostAssignerShould extends ServicesModuleUnitTestCase {

    private ServiceCostAssigner subject;
    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new ServiceCostAssigner(repository);
    }

    @Test
    void assign_cost_to_existing_service() {
        var service = ServiceMother.random();

        shouldSearch(service);

        subject.assign(service.id(), "32f02af7-5245-46f2-a7dd-2c28a6b16abb", 20, "WIN");

        shouldHaveSaved(service);
    }

    @Test
    void not_assign_cost_when_service_no_exists() {
        var service = ServiceMother.random();

        assertThrows(
            ServiceNotExistException.class,
            () -> subject.assign(service.id(), "32f02af7-5245-46f2-a7dd-2c28a6b16abb", 20, "WIN")
        );
    }
}
