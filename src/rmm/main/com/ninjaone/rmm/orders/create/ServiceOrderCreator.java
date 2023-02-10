package com.ninjaone.rmm.orders.create;

import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.rmm.orders.domain.ServiceOrderRepository;
import com.ninjaone.rmm.orders.domain.model.ServiceOrder;
import com.ninjaone.rmm.orders.domain.model.ServiceOrderId;
import com.ninjaone.rmm.services.application.find.FindServiceByIdQuery;
import com.ninjaone.shared.domain.CustomerId;
import com.ninjaone.shared.domain.DeviceId;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.ServiceId;
import com.ninjaone.shared.domain.bus.event.EventBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;

@Service
public final class ServiceOrderCreator {
    private final ServiceOrderRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;

    public ServiceOrderCreator(ServiceOrderRepository repository, EventBus eventBus, QueryBus queryBus) {

        this.repository = repository;
        this.eventBus = eventBus;
        this.queryBus = queryBus;
    }

    public void create(String id, String serviceId, String deviceId, String customerId) {
        ensureDeviceExist(deviceId);
        ensureServiceExist(serviceId);

        ServiceOrder service = ServiceOrder.create(
            new ServiceOrderId(id),
            new ServiceId(serviceId),
            new DeviceId(deviceId),
            new CustomerId(customerId)
        );

        repository.save(service);

        eventBus.publish(service.pullDomainEvents());
    }

    private void ensureDeviceExist(String deviceId) {
        queryBus.ask(new FindDeviceByIdQuery(deviceId));
    }

    private void ensureServiceExist(String serviceId) {
        queryBus.ask(new FindServiceByIdQuery(serviceId));
    }
}