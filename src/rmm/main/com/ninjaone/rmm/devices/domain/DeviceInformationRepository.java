package com.ninjaone.rmm.devices.domain;

import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.shared.domain.DeviceId;
import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface DeviceInformationRepository {
    void save(DeviceInformation deviceInformation);

    List<DeviceInformation> matching(Criteria criteria);

    Optional<DeviceInformation> search(DeviceId deviceId);

    void delete(DeviceInformation deviceInformation);
}
