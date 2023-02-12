package com.ninjaone.rmm.orders.create;

import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.rmm.orders.domain.DeviceOrderRepository;
import com.ninjaone.rmm.orders.domain.model.DeviceOrder;
import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.rmm.orders.domain.model.DeviceOrderId;
import com.ninjaone.rmm.orders.domain.model.OrderName;
import com.ninjaone.rmm.shared.domain.CustomerId;
import com.ninjaone.rmm.shared.domain.DeviceId;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.EventBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;

@Service
public final class DeviceOrderCreator {
    private final DeviceOrderRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;

    public DeviceOrderCreator(DeviceOrderRepository repository, EventBus eventBus, QueryBus queryBus) {

        this.repository = repository;
        this.eventBus = eventBus;
        this.queryBus = queryBus;
    }

    public void create(String id, String deviceId, String customerId) {
        DeviceResponse response = queryBus.ask(new FindDeviceByIdQuery(deviceId));

        DeviceOrder device = DeviceOrder.orderFor(
            new DeviceOrderId(id),
            new DeviceId(deviceId),
            new CustomerId(customerId),
            new OrderName(response.type())
        );

        repository.save(device);

        eventBus.publish(device.pullDomainEvents());
    }
}
