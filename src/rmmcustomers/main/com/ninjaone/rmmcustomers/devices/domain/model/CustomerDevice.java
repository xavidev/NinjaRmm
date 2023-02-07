package com.ninjaone.rmmcustomers.devices.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.util.UUID;

@Entity
public class CustomerDevice {
    @Id
    private UUID id;

    private UUID deviceId;
    private UUID customerId;
    private String systemName;

    private CustomerDevice(UUID id, UUID deviceId, UUID customerId, String systemName) {
        this.id = id;
        this.systemName = systemName;
    }

    protected CustomerDevice() {

    }

    public static CustomerDevice create(String id, String devideId, String customerId) {
        return new CustomerDevice(UUID.fromString(id), UUID.fromString(devideId), UUID.fromString(customerId), getSystemName(UUID.fromString(id)));
    }

    private static String getSystemName(UUID id) {
        return id.toString().split("-")[0] + "test-user";
    }
}
