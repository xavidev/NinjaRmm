package com.ninjaone.rmm.devices.application.create;


import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.rmm.devices.domain.model.Device;

public final class DeviceCreator {

    private final DeviceRepository repository;

    public DeviceCreator(DeviceRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String type) {
        Device device = Device.create(id, type);

        repository.save(device);
    }
}
