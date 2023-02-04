package com.ninjaone.rmm.costs.application.create_cost_policy;

import com.ninjaone.rmm.costs.domain.CostPolicyRepository;
import com.ninjaone.rmm.costs.domain.model.CostPolicy;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.ServiceId;

public final class CostPolicyCreator {

    private ServiceRepository serviceRepository;
    private CostPolicyRepository costPolicyRepository;

    public CostPolicyCreator(ServiceRepository serviceRepository, CostPolicyRepository costPolicyRepository) {

        this.serviceRepository = serviceRepository;
        this.costPolicyRepository = costPolicyRepository;
    }

    public void create(String policyId, String serviceId, double cost, String policyType, String policyValue) {
        var service = this.serviceRepository.search(new ServiceId(serviceId)).get();

        CostPolicy costPolicy = CostPolicy.assignTo(policyId, service.id(), cost, policyType, policyValue);

        costPolicyRepository.save(costPolicy);
    }
}
