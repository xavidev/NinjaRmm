package com.ninjaone.rmm.devices.domain.model;

import com.ninjaone.shared.domain.StringValue;

public class DeviceType extends StringValue {
    public DeviceType(String type) {
        super(type);
    }

    private DeviceType() {
        super(null);
    }
}
