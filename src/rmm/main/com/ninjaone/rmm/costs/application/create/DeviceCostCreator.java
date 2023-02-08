package com.ninjaone.rmm.costs.application.create;

import com.ninjaone.rmm.costs.domain.DeviceCostRepository;
import com.ninjaone.rmm.costs.domain.model.DeviceCost;
import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.shared.devices.application.FindDeviceByIdQuery;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.EventBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;

@Service
public final class DeviceCostCreator {

    private DeviceCostRepository costRepository;
    private final QueryBus bus;
    private EventBus eventBus;

    public DeviceCostCreator(DeviceCostRepository costRepository, QueryBus bus, EventBus eventBus) {
        this.costRepository = costRepository;
        this.bus = bus;
        this.eventBus = eventBus;
    }

    public void create(String deviceId, String customerId) {
        DeviceResponse response = bus.ask(new FindDeviceByIdQuery(deviceId));

        DeviceCost cost = DeviceCost.create(deviceId, customerId, response.cost(), response.type());

        costRepository.save(cost);

        eventBus.publish(cost.pullDomainEvents());
    }
}
