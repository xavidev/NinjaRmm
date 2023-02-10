package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.shared.domain.DeviceId;
import com.ninjaone.shared.domain.DomainException;

public final class DeviceNotExistsException extends DomainException {
    public DeviceNotExistsException(DeviceId deviceId) {
        super(
            "device_type_not_exist",
            String.format("The device type <%s> not exist.", deviceId.value())
        );
    }
}
