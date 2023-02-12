package com.ninjaone.rmmcustomers.customerdevcies.domain;

import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDevice;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDeviceId;

import java.util.Optional;

public interface  CustomerDeviceRepository {

    void save(CustomerDevice device);

    Optional<CustomerDevice> search(CustomerDeviceId customerDeviceId);
}
