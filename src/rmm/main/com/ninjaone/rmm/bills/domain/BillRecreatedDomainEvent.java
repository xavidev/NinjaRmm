package com.ninjaone.rmm.bills.domain;

import com.ninjaone.shared.domain.bus.event.DomainEvent;

public final class BillRecreatedDomainEvent extends DomainEvent {
    public BillRecreatedDomainEvent(String id) {
        super(id);
    }
}
