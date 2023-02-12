package com.ninjaone.rmmcustomers.customerdevcies.application.updatecost;

import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceNotExistException;
import com.ninjaone.rmmcustomers.customerdevcies.domain.CustomerDeviceRepository;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDevice;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDeviceId;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerService;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;

@Service
public final class DeviceCostUpdater {

    private final CustomerDeviceRepository repository;

    public DeviceCostUpdater(CustomerDeviceRepository repository) {
        this.repository = repository;
    }

    public void update(String deviceId, String cost, String itemType, String concept) {
        CustomerDevice device = repository
            .search(new CustomerDeviceId(deviceId))
            .orElseThrow(() -> new CustomerDeviceNotExistException(new CustomerDeviceId(deviceId)));

        if (itemType.equals("service")) {
            device.addService(new CustomerService(deviceId, concept));
        }
        device.updateCost(new Price(cost));

        repository.save(device);
    }
}
