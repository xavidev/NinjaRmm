package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.domain.model.Device;
import com.ninjaone.rmm.devices.domain.model.DeviceId;


import java.util.Optional;

public interface DeviceRepository {
    void save(Device device);
    Optional<Device> search(DeviceId id);
}
