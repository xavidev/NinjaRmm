package com.ninjaone.rmm.services.domain;

import com.ninjaone.shared.domain.DomainException;

public final class DeviceTypeNotExistException extends DomainException {
    public DeviceTypeNotExistException(String deviceType) {
        super("device_type_not_exist", String.format("The device type <%s> not exist.", deviceType));
    }
}
