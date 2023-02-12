package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.orders.domain.ServiceOrderCreatedDomainEvent;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({ServiceOrderCreatedDomainEvent.class})
public final class CreateBillItemOnServiceOrderCreated {

    private final ServiceBillItemCreator creator;

    public CreateBillItemOnServiceOrderCreated(ServiceBillItemCreator creator) {
        this.creator = creator;
    }

    @EventListener
    public void on(ServiceOrderCreatedDomainEvent event) {
        this.creator.create(new BillCreationParams(
            event.aggregateId(),
            event.name(),
            event.deviceId(),
            event.serviceId(),
            event.customerId(),
            event.itemType()
        ));
    }
}

