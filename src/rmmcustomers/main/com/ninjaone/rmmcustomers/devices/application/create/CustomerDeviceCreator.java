package com.ninjaone.rmmcustomers.devices.application.create;

import com.ninjaone.rmmcustomers.devices.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.devices.domain.model.CustomerDevice;
import com.ninjaone.shared.devices.application.FindDeviceByIdQuery;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.EventBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;

import java.util.UUID;

@Service
public final class CustomerDeviceCreator {
    private final CustomerDeviceRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;

    public CustomerDeviceCreator(CustomerDeviceRepository repository, EventBus eventBus, QueryBus queryBus) {

        this.repository = repository;
        this.eventBus = eventBus;
        this.queryBus = queryBus;
    }

    public void create(String id, String deviceId, String customerId) {

        ensureDeviceExist(deviceId);

        CustomerDevice device = CustomerDevice.create(
            id,
            deviceId,
            customerId
        );

        repository.save(device);

        eventBus.publish(device.pullDomainEvents());
    }

    private void ensureDeviceExist(String deviceId) {
        queryBus.ask(new FindDeviceByIdQuery(deviceId));
    }
}
