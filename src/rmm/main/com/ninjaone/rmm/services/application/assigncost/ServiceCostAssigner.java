package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.devices.application.find.FindDeviceByCriteriaQuery;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.shared.domain.UuidGenerator;
import com.ninjaone.shared.domain.bus.query.QueryBus;

@com.ninjaone.shared.domain.Service
public final class ServiceCostAssigner {
    private final ServiceRepository serviceRepository;

    private final QueryBus queryBus;

    private final UuidGenerator uuidGenerator;

    public ServiceCostAssigner(ServiceRepository serviceRepository, QueryBus queryBus, UuidGenerator uuidGenerator) {
        this.serviceRepository = serviceRepository;
        this.queryBus = queryBus;
        this.uuidGenerator = uuidGenerator;
    }

    public void assign(String serviceId, double cost, String deviceType) {
        Service service = serviceRepository.search(new ServiceId(serviceId)).
            orElseThrow(() -> new ServiceNotExistException(new ServiceId(serviceId)));

        queryBus.ask(new FindDeviceByCriteriaQuery(deviceType));

        service.addCost(uuidGenerator.generate(), cost, deviceType);

        serviceRepository.save(service);
    }
}
