package com.ninjaone.rmmcustomers.customerdevcies.application.create;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;
import com.ninjaone.shared.domain.orders.DeviceOrderCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({DeviceOrderCreatedDomainEvent.class})
public final class CreateCustomerDeviceOnDeviceOrderCreated {

    private final CustomerDeviceCreator creator;

    public CreateCustomerDeviceOnDeviceOrderCreated(CustomerDeviceCreator creator) {
        this.creator = creator;
    }

    @EventListener
    public void on (DeviceOrderCreatedDomainEvent event){
        creator.create(
            event.aggregateId(),
            event.customerId(),
            event.name());
    }
}
