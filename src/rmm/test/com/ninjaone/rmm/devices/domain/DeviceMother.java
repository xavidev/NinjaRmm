package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.domain.model.Device;
import com.ninjaone.rmm.shared.domain.UuidMother;


public final class DeviceMother {
    public static Device Windows() {
        return Device.create(UuidMother.random(), "Windows work station");
    }
}
