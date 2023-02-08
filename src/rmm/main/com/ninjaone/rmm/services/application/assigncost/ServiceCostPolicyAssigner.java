package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.*;

@com.ninjaone.shared.domain.Service
public final class ServiceCostPolicyAssigner {
    private final ServiceRepository serviceRepository;

    public ServiceCostPolicyAssigner(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void assign(String serviceId, String policyType, String policyValue) {
        ServiceInformation serviceInformation = serviceRepository.search(new ServiceId(serviceId)).
            orElseThrow(() -> new ServiceNotExistException(new ServiceId(serviceId)));

        serviceInformation.addCostPolicy(CostPolicy.makeFor(policyType, policyValue));

        serviceRepository.save(serviceInformation);
    }
}
