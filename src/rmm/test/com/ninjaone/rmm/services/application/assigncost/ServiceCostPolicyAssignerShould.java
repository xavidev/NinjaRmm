package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.devices.application.find.FindDeviceByCriteriaQuery;
import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.ServiceCostPolicyMother;
import com.ninjaone.rmm.services.domain.ServiceMother;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceCostPolicyAssignerShould extends ServicesModuleUnitTestCase {

    private ServiceCostAssigner subject;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new ServiceCostAssigner(serviceRepository, queryBus, uuidGenerator);
    }

    @Test
    void assign_cost_to_existing_service() {
        var service = ServiceMother.random();
        var serviceCost = ServiceCostPolicyMother.random();

        shouldSearch(service);
        shouldGenerateUuid(serviceCost.id());

        subject.assign(service.id(), 20, "WIN");

        shouldHaveSaved(service);
    }

    @Test
    void not_assign_cost_when_service_no_exists() {
        var service = ServiceMother.random();

        assertThrows(
            ServiceNotExistException.class,
            () -> subject.assign(service.id(), 20, "WIN")
        );
    }

    @Test
    void not_assign_cost_by_device_when_device_not_exist() {
        var service = ServiceMother.random();

        shouldSearch(service);

        shouldThrowWhenAskFor(new FindDeviceByCriteriaQuery("NOT_EXIST"));

        shouldNotSave(service);
    }
}
