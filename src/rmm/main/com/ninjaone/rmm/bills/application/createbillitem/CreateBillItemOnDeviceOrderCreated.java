package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.orders.domain.DeviceOrderCreatedDomainEvent;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({DeviceOrderCreatedDomainEvent.class})
public final class CreateBillItemOnDeviceOrderCreated {

    private final BillItemCreator creator;

    public CreateBillItemOnDeviceOrderCreated(BillItemCreator creator) {
        this.creator = creator;
    }

    public void on(DeviceOrderCreatedDomainEvent event) {
        this.creator.create(event.aggregateId(), event.customerId(), event.name(), event.itemType());
    }
}
