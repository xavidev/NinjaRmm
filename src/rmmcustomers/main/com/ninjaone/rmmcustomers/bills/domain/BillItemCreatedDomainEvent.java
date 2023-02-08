package com.ninjaone.rmmcustomers.bills.domain;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

public final class BillItemCreatedDomainEvent extends DomainEvent {

    private final String customerId;
    private final String concept;
    private final double cost;

    public BillItemCreatedDomainEvent(String id, String customerId, String concept, double cost) {
        super(id);

        this.customerId = customerId;
        this.concept = concept;
        this.cost = cost;
    }

    public String customerId() {
        return customerId;
    }

    public String concept() {
        return concept;
    }

    public double cost() {
        return cost;
    }
}
