package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.devices.domain.DeviceInformationMother;
import com.ninjaone.rmm.services.ServicesModuleUnitTestCase;
import com.ninjaone.rmm.services.domain.InvalidCostPolicyException;
import com.ninjaone.rmm.services.domain.MalFormedCostPolicyException;
import com.ninjaone.rmm.services.domain.ServiceCostPolicyMother;
import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import com.ninjaone.rmm.shared.domain.PerDeviceTypeCostPolicy;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServiceCostPolicyAssignerShould extends ServicesModuleUnitTestCase {

    private ServiceCostPolicyAssigner assigner;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        assigner = new ServiceCostPolicyAssigner(serviceInformationRepository);
    }

    @Test
    void assign_valid_service_cost_policy(){

        AssignServiceCostPolicyCommand command = AssignServiceCostPolicyCommandMother.perDeviceType();

        var actualService = ServiceInformationMother.antivirus("100");

        shouldSearch(actualService);

        assigner.assign(actualService.id(), command.policyType(), command.policyValue());

        var withPolicyService = ServiceInformationMother.antivirus("100");

        withPolicyService.addCostPolicy(ServiceCostPolicyMother.forDevice(DeviceInformationMother.Windows(), "200"));

        shouldHaveSaved(withPolicyService);
    }

    @Test
    void not_assign_an_invalid_type_cost_policy(){

        AssignServiceCostPolicyCommand command = AssignServiceCostPolicyCommandMother.invalid();

        var actualService = ServiceInformationMother.antivirus("100");

        shouldSearch(actualService);

        Assert.assertThrows(
            InvalidCostPolicyException.class,
            () -> assigner.assign(actualService.id(), command.policyType(), command.policyValue())
        );
    }

    @Test
    void not_assign_mal_formed_cost_policy(){

        AssignServiceCostPolicyCommand command = AssignServiceCostPolicyCommandMother.malFormed();

        var actualService = ServiceInformationMother.antivirus("100");

        shouldSearch(actualService);

        Assert.assertThrows(
            MalFormedCostPolicyException.class,
            () -> assigner.assign(actualService.id(), command.policyType(), command.policyValue())
        );
    }

}
