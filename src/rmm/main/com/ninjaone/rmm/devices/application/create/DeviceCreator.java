package com.ninjaone.rmm.devices.application.create;


import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.rmm.devices.domain.model.Device;
import com.ninjaone.shared.domain.Service;

@Service
public final class DeviceCreator {

    private final DeviceRepository repository;

    public DeviceCreator(DeviceRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String type, double cost) {
        Device device = Device.create(id, type, cost);

        repository.save(device);
    }
}
