package com.ninjaone.rmm.devices.application.create;


import com.ninjaone.rmm.devices.application.find.FindCriteria;
import com.ninjaone.rmm.devices.domain.DeviceInformationRepository;
import com.ninjaone.rmm.devices.domain.DeviceTypeAlreadyExistsException;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.devices.domain.model.DeviceType;
import com.ninjaone.shared.domain.Service;

@Service
public final class DeviceCreator {

    private final DeviceInformationRepository repository;

    public DeviceCreator(DeviceInformationRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String type, String cost) {

        var device = repository.matching(FindCriteria.perDeviceType(type))
            .stream()
            .findFirst();

        if(device.isPresent()){
            throw new DeviceTypeAlreadyExistsException(new DeviceType(type));
        }

        DeviceInformation deviceInformation = DeviceInformation.create(id, type, cost);

        repository.save(deviceInformation);
    }
}
