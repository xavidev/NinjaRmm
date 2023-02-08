package com.ninjaone.rmmcustomers.bills.domain;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

import java.util.UUID;

public final class BillExplanationCreatedDomainEvent extends DomainEvent {
    public BillExplanationCreatedDomainEvent(String id) {
        super(id);
    }
}
