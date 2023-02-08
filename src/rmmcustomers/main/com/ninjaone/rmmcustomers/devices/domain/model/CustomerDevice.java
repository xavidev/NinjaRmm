package com.ninjaone.rmmcustomers.devices.domain.model;

import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.devices.CustomerDeviceCreatedDomainEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.UUID;

@Entity
public class CustomerDevice extends AggregateRoot {
    @Id
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID id;
    private UUID deviceId;
    private UUID customerId;
    private String systemName;

    private CustomerDevice(UUID deviceId, UUID customerId, String systemName) {
        this.id = deviceId;
        this.customerId = customerId;
        this.systemName = systemName;

        record(new CustomerDeviceCreatedDomainEvent(this.id.toString(), customerId.toString()));
    }

    protected CustomerDevice() {

    }

    public static CustomerDevice create(String deviceId, String customerId) {
        return new CustomerDevice(
            UUID.fromString(deviceId),
            UUID.fromString(customerId),
            getSystemName(UUID.fromString(deviceId))
        );
    }

    private static String getSystemName(UUID id) {
        return id.toString().split("-")[0] + "test-user";
    }
}
