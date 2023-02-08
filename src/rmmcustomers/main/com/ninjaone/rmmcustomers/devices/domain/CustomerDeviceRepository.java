package com.ninjaone.rmmcustomers.devices.domain;

import com.ninjaone.rmmcustomers.devices.domain.model.CustomerDevice;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerDeviceRepository extends CrudRepository<CustomerDevice, UUID> {
}
