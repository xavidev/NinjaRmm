package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.shared.domain.RandomElementPicker;

public final class DeviceResponseMother {
    public static DeviceResponse random() {
        return fromDevice(RandomElementPicker.from(
            DeviceMother.Mac(), DeviceMother.Windows()));
    }

    public static DeviceResponse fromDevice(DeviceInformation device) {
        return new DeviceResponse(device.type(), device.cost());
    }
}
