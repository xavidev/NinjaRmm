package com.ninjaone.rmmcustomers.bills.application.createbillexplanation;

import com.ninjaone.rmmcustomers.bills.domain.BillItemCreatedDomainEvent;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber(BillItemCreatedDomainEvent.class)
public final class CreateBillExplanationOnBillItemCreated {

    private final BillExplanationCreator creator;

    public CreateBillExplanationOnBillItemCreated(BillExplanationCreator creator) {
        this.creator = creator;
    }

    public void on(BillItemCreatedDomainEvent event) {
        creator.create(event.customerId());
    }
}
