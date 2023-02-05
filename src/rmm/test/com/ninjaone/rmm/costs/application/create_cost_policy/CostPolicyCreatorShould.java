package com.ninjaone.rmm.costs.application.create_cost_policy;

import com.ninjaone.rmm.costs.CostsModuleUnitTestCase;
import com.ninjaone.rmm.costs.domain.CostPolicyMother;
import com.ninjaone.rmm.costs.domain.model.CostPolicy;
import com.ninjaone.rmm.services.domain.ServiceMother;
import com.ninjaone.rmm.services.domain.model.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CostPolicyCreatorShould extends CostsModuleUnitTestCase {

    private CostPolicyCreator subject;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        subject = new CostPolicyCreator(serviceRepository, costPolicyRepository);
    }
    @Test
    void create_new_cost_policy_for_an_existent_service() {
        Service service = ServiceMother.random();
        CostPolicy costPolicy = CostPolicyMother.randomFor(service.id());

        shouldSearch(service);

        subject.create(costPolicy.id(), service.id(), costPolicy.cost(), costPolicy.type(), costPolicy.value());

        shouldHaveSaved(costPolicy);
    }
}
