package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.orders.domain.ServiceOrderCreatedDomainEvent;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({ServiceOrderCreatedDomainEvent.class})
public final class CreateBillItemOnServiceOrderCreated {

    private final BillItemCreator creator;

    public CreateBillItemOnServiceOrderCreated(BillItemCreator creator) {
        this.creator = creator;
    }

    public void on(ServiceOrderCreatedDomainEvent event) {
        this.creator.create(event.aggregateId(), event.serviceId(), event.customerId(), event.name(), event.itemType());
    }
}
