package com.ninjaone.rmm.services.application.calculatecost;

import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.rmm.services.domain.ServiceInformationRepository;
import com.ninjaone.rmm.services.domain.ServiceNotExistException;
import com.ninjaone.shared.domain.ServiceId;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryBus;

@Service
public final class ServiceCostCalculator {
    private final ServiceInformationRepository repository;
    private final QueryBus bus;

    public ServiceCostCalculator(ServiceInformationRepository repository, QueryBus bus) {
        this.repository = repository;
        this.bus = bus;
    }

    public ServieCostResponse costFor(String serviceId, String deviceId) {
        ServiceInformation info = repository.search(new ServiceId(serviceId))
            .orElseThrow(()-> new ServiceNotExistException(new ServiceId(serviceId)));

        DeviceResponse deviceInfo = bus.ask(new FindDeviceByIdQuery(deviceId));

        return new ServieCostResponse(info.costFor(deviceInfo.type()));
    }
}
