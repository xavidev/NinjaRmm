package com.ninjaone.rmm.orders.domain.model;

import com.ninjaone.shared.domain.UuidIdentifier;

public final class ServiceOrderId extends UuidIdentifier {
    public ServiceOrderId(String value) {
        super(value);
    }

    private ServiceOrderId() {
    }
}

