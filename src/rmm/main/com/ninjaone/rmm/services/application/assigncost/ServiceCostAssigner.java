package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.services.domain.DeviceTypeRepository;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;

@com.ninjaone.shared.domain.Service
public final class ServiceCostAssigner {
    private final ServiceRepository serviceRepository;
    private DeviceTypeRepository deviceTypeRepository;

    public ServiceCostAssigner(ServiceRepository serviceRepository, DeviceTypeRepository deviceTypeRepository) {
        this.serviceRepository = serviceRepository;
        this.deviceTypeRepository = deviceTypeRepository;
    }

    public void assign(String serviceId, String costId, double cost, String deviceType) {
        Service service = serviceRepository.search(new ServiceId(serviceId)).
            orElseThrow(() -> new ServiceNotExistException(new ServiceId(serviceId)));


        service.addCost(costId, cost, deviceType);

        serviceRepository.save(service);
    }
}
