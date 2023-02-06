package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.domain.model.Device;
import com.ninjaone.rmm.devices.domain.model.DeviceId;
import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository {
    void save(Device device);

    List<Device> matching(Criteria criteria);

    Optional<Device> search(DeviceId deviceId);

    void delete(Device device);
}
