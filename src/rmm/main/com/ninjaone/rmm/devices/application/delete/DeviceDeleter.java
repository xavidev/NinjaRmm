package com.ninjaone.rmm.devices.application.delete;

import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.rmm.devices.domain.model.Device;
import com.ninjaone.rmm.devices.domain.model.DeviceId;

import java.util.Optional;

public final class DeviceDeleter {
    private final DeviceRepository repository;

    public DeviceDeleter(DeviceRepository repository) {
        this.repository = repository;
    }

    public void delete(String id) {
        Optional<Device> device = repository.search(new DeviceId(id));

        if (device.isEmpty()) {
            return;
        }

        Device toDelete = device.get();
        repository.delete(toDelete);
        toDelete.delete();
    }
}
