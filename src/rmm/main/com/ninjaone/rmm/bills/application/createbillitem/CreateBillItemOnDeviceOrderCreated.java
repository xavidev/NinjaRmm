package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.orders.domain.DeviceOrderCreatedDomainEvent;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({DeviceOrderCreatedDomainEvent.class})
public final class CreateBillItemOnDeviceOrderCreated {

    private final BillItemCreator creator;

    public CreateBillItemOnDeviceOrderCreated(BillItemCreator creator) {
        this.creator = creator;
    }

    @EventListener
    public void on(DeviceOrderCreatedDomainEvent event) {
        this.creator.create(new BillCreationParams(
            event.aggregateId(),
            event.name(),
            event.deviceId(),
            null,
            event.customerId(),
            event.itemType()
        ));
    }
}

