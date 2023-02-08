package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.domain.model.DeviceType;
import com.ninjaone.shared.domain.DomainException;

public final class DeviceAlreadyExistException extends DomainException {
    public DeviceAlreadyExistException(DeviceType type) {
        super(
            "device_type_not_exist",
            String.format("The device type <%s> not exist.", type.value())
        );
    }
}
