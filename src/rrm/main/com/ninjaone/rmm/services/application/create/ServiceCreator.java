package com.ninjaone.rmm.services.application.create;


import com.ninjaone.rmm.services.domain.DeviceServiceRepository;
import com.ninjaone.rmm.services.domain.model.DeviceService;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.rmm.services.domain.model.ServiceName;
import com.ninjaone.shared.domain.Service;

@Service
public final class ServiceCreator {

    private final DeviceServiceRepository repository;

    public ServiceCreator(DeviceServiceRepository repository) {

        this.repository = repository;
    }
    public void create(String id, String name) {
        var service = DeviceService.create(new ServiceId(id), new ServiceName(name));
        repository.save(service);
    }
}
