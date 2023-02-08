package com.ninjaone.rmmcustomers.bills.application.createbillitem;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;
import com.ninjaone.shared.domain.devices.DeviceCostCreatedDomainEvent;

@Service
@DomainEventSubscriber(DeviceCostCreatedDomainEvent.class)
public final class CreateBillItemOnDeviceCostCreated {

    private final BillItemCreator creator;

    public CreateBillItemOnDeviceCostCreated(BillItemCreator creator) {
        this.creator = creator;
    }

    public void on(DeviceCostCreatedDomainEvent event) {
        this.creator.create(event.aggregateId(), event.customerId(), event.type(), event.itemType(), event.cost());
    }
}
