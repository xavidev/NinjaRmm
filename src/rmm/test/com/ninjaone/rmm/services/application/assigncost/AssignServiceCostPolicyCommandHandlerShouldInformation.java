package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.ServiceCostPolicyMother;
import com.ninjaone.rmm.services.domain.ServiceMother;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignServiceCostPolicyCommandHandlerShouldInformation extends ServicesModuleUnitTestCase {

    private ServiceCostPolicyAssigner subject;
    private AssignServiceCostPolicyCommandHandler handler;
    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new ServiceCostPolicyAssigner(serviceRepository);
        handler = new AssignServiceCostPolicyCommandHandler(subject);
    }

    @Test
    void assign_cost_to_existing_service() {
        var service = ServiceMother.random();
        var serviceCost = ServiceCostPolicyMother.random();

        shouldSearch(service);
//        shouldGenerateUuid(serviceCost.id());

        handler.handle(new AssignServiceCostPolicyCommand(service.id(), 20, "WIN"));

        shouldHaveSaved(service);
    }

    @Test
    void not_assign_cost_when_service_no_exists() {
        var service = ServiceMother.random();

        assertThrows(
            ServiceNotExistException.class,
            () -> handler.handle(new AssignServiceCostPolicyCommand(service.id(), 20, "WIN"))
        );
    }
}
