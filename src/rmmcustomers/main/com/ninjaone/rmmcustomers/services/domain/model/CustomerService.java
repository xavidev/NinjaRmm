package com.ninjaone.rmmcustomers.services.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Entity
public class CustomerService {
    @Id
    private UUID id;

    private UUID deviceId;

    private String name;
    private int count;

    public CustomerService(UUID id, UUID deviceId, String name) {
        this.id = id;
        this.deviceId = deviceId;
        this.name = name;
        this.count = 0;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increment(){
        count++;
    }
}
