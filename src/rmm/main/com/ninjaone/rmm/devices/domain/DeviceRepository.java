package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.domain.model.Device;
import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;

public interface DeviceRepository {
    void save(Device device);

    List<Device> matching(Criteria criteria);
}
