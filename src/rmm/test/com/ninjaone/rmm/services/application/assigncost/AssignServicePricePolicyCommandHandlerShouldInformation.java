package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.ServiceCostPolicyMother;
import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignServicePricePolicyCommandHandlerShouldInformation extends ServicesModuleUnitTestCase {

    private ServiceCostPolicyAssigner subject;
    private AssignServiceCostPolicyCommandHandler handler;
    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new ServiceCostPolicyAssigner(serviceInformationRepository);
        handler = new AssignServiceCostPolicyCommandHandler(subject);
    }

    @Test
    void assign_cost_to_existing_service() {
        var service = ServiceInformationMother.random();
        var serviceCost = ServiceCostPolicyMother.random();

        shouldSearch(service);
//        shouldGenerateUuid(serviceCost.id());

        handler.handle(new AssignServiceCostPolicyCommand(service.id(), "WIN", 20));

        shouldHaveSaved(service);
    }

    @Test
    void not_assign_cost_when_service_no_exists() {
        var service = ServiceInformationMother.random();

        assertThrows(
            ServiceNotExistException.class,
            () -> handler.handle(new AssignServiceCostPolicyCommand(service.id(), "WIN", 20))
        );
    }
}
