package com.ninjaone.rmm.orders.domain.model;

import com.ninjaone.shared.domain.UuidIdentifier;

public final class DeviceOrderId extends UuidIdentifier {

    public DeviceOrderId(String value) {
        super(value);
    }

    private DeviceOrderId() {
    }

}
