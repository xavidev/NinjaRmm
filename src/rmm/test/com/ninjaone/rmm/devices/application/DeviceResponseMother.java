package com.ninjaone.rmm.devices.application;

import com.ninjaone.rmm.devices.domain.DeviceInformationMother;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.shared.domain.RandomElementPicker;

public final class DeviceResponseMother {
    public static DeviceResponse random() {
        return fromDevice(RandomElementPicker.from(
            DeviceInformationMother.Mac(), DeviceInformationMother.Windows()));
    }

    public static DeviceResponse fromDevice(DeviceInformation device) {
        return new DeviceResponse(device.id(), device.type(), device.cost());
    }
}
