package com.ninjaone.shared.domain.bills;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

public final class BillItemCreatedDomainEvent extends DomainEvent {

    private final String customerId;
    private final String itemType;
    private final String concept;
    private final String cost;

    public BillItemCreatedDomainEvent(String id, String customerId, String itemType, String concept, String cost) {
        super(id);

        this.customerId = customerId;
        this.itemType = itemType;
        this.concept = concept;
        this.cost = cost;
    }

    public String customerId() {
        return customerId;
    }

    public String itemType() {
        return itemType;
    }

    public String concept() {
        return concept;
    }

    public String cost() {
        return cost;
    }
}
