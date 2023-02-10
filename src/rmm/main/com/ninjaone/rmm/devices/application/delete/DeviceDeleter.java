package com.ninjaone.rmm.devices.application.delete;

import com.ninjaone.rmm.devices.domain.DeviceInformationRepository;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.shared.domain.DeviceId;
import com.ninjaone.shared.domain.Service;

import java.util.Optional;

@Service
public final class DeviceDeleter {
    private final DeviceInformationRepository repository;

    public DeviceDeleter(DeviceInformationRepository repository) {
        this.repository = repository;
    }

    public void delete(String id) {
        Optional<DeviceInformation> device = repository.search(new DeviceId(id));

        if (device.isEmpty()) {
            return;
        }

        DeviceInformation toDelete = device.get();
        repository.delete(toDelete);
    }
}
