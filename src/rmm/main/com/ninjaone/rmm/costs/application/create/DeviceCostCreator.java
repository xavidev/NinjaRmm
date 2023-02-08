package com.ninjaone.rmm.costs.application.create;

import com.ninjaone.rmm.costs.domain.DeviceCostRepository;
import com.ninjaone.rmm.costs.domain.model.DeviceCost;
import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryBus;

@Service
public final class DeviceCostCreator {

    private DeviceCostRepository costRepository;
    private final QueryBus bus;

    public DeviceCostCreator(DeviceCostRepository costRepository, QueryBus bus) {
        this.costRepository = costRepository;
        this.bus = bus;
    }

    public void create(String aggregateId, String customerId) {
        DeviceResponse response = bus.ask(new FindDeviceByIdQuery(aggregateId));

        DeviceCost.create(aggregateId, customerId, response.cost(), response.type());
    }
}
