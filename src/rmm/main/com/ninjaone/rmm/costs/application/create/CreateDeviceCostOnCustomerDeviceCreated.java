package com.ninjaone.rmm.costs.application.create;


import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;
import com.ninjaone.shared.domain.devices.CustomerDeviceCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({CustomerDeviceCreatedDomainEvent.class})
public final class CreateDeviceCostOnCustomerDeviceCreated  {

    private DeviceCostCreator creator;

    public CreateDeviceCostOnCustomerDeviceCreated(DeviceCostCreator creator) {
        this.creator = creator;
    }

    @EventListener
    public void on(CustomerDeviceCreatedDomainEvent event) {
        creator.create(event.aggregateId(), event.customerId());
    }
}
