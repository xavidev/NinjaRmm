package com.ninjaone.rmm.devices.application.find;

import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.rmm.devices.domain.DeviceInformationRepository;
import com.ninjaone.rmm.devices.domain.DeviceNotExistsException;
import com.ninjaone.shared.domain.DeviceId;
import com.ninjaone.shared.domain.Service;

@Service
public final class DeviceFinder {

    private final DeviceInformationRepository repository;

    public DeviceFinder(DeviceInformationRepository repository) {
        this.repository = repository;
    }

    public DeviceResponse find(String deviceId) {
        var device = repository.search(new DeviceId(deviceId))
            .orElseThrow(() -> new DeviceNotExistsException(new DeviceId(deviceId)));

        return new DeviceResponse(device.type(), device.cost());
    }
}
