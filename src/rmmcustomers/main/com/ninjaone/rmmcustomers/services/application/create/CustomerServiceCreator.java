package com.ninjaone.rmmcustomers.services.application.create;

import com.ninjaone.rmm.devices.application.FindDeviceByIdQuery;
import com.ninjaone.rmm.services.application.FindServiceByIdQuery;
import com.ninjaone.rmmcustomers.devices.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.devices.domain.model.CustomerDevice;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.EventBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;

import java.util.UUID;

@Service
public final class CustomerServiceCreator {
    private final CustomerDeviceRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;

    public CustomerServiceCreator(CustomerDeviceRepository repository, EventBus eventBus, QueryBus queryBus) {

        this.repository = repository;
        this.eventBus = eventBus;
        this.queryBus = queryBus;
    }

    public void create(String serviceId, String deviceId, String customerId) {

        ensureServiceExist(serviceId);
        ensureDeviceExist(deviceId);

        CustomerDevice device = CustomerDevice.create(
            deviceId,
            customerId
        );

        eventBus.publish(device.pullDomainEvents());
    }

    private void ensureServiceExist(String serviceId) {
        queryBus.ask(new FindServiceByIdQuery(serviceId));
    }

    private void ensureDeviceExist(String deviceId) {
        queryBus.ask(new FindDeviceByIdQuery(deviceId));
    }
}
