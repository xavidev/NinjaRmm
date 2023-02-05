package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.DeviceType;
import com.ninjaone.rmm.services.domain.model.DeviceTypeId;

import java.util.Optional;

public interface DeviceTypeRepository {
    Optional<DeviceType> search(DeviceTypeId id);
}
