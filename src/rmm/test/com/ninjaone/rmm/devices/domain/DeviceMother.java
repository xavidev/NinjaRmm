package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.domain.model.Device;


public final class DeviceMother {
    public static Device Windows() {
        return Device.create("25cb7a4e-974a-418f-a9e5-14118da7ea4f", "Windows");
    }
}
