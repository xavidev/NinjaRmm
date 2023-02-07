package com.ninjaone.rmm.devices.domain.model;

import com.ninjaone.shared.domain.UuidIdentifier;

public final class DeviceId extends UuidIdentifier {
    public DeviceId(String value) {
        super(value);
    }

    private DeviceId(){

    }
}
