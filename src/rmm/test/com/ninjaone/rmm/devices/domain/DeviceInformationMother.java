package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.shared.domain.UuidMother;


public final class DeviceInformationMother {
    public static DeviceInformation Windows() {
        return DeviceInformation.create(UuidMother.random(), "Windows", "20");
    }

    public static DeviceInformation Mac() {
        return DeviceInformation.create(UuidMother.random(), "Mac", "50");
    }

    public static DeviceInformation random() {
        return null;
    }
}
