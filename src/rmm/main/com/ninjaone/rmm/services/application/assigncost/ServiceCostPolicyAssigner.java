package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.services.domain.ServiceInformationRepository;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.shared.domain.PerDeviceTypeCostPolicy;
import com.ninjaone.rmm.shared.domain.ServiceId;


@com.ninjaone.shared.domain.Service
public final class ServiceCostPolicyAssigner {
    private final ServiceInformationRepository serviceInformationRepository;

    public ServiceCostPolicyAssigner(ServiceInformationRepository serviceInformationRepository) {
        this.serviceInformationRepository = serviceInformationRepository;
    }

    public void assign(String serviceId, String deviceType, String cost) {
        ServiceInformation serviceInformation = serviceInformationRepository.search(new ServiceId(serviceId)).
            orElseThrow(() -> new ServiceNotExistException(new ServiceId(serviceId)));

        serviceInformation.addCostPolicy(new PerDeviceTypeCostPolicy(deviceType, cost));

        serviceInformationRepository.save(serviceInformation);
    }
}
