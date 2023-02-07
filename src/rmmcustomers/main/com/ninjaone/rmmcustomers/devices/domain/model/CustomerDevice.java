package com.ninjaone.rmmcustomers.devices.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.util.UUID;

@Entity
public class CustomerDevice {
    @Id
    private UUID id;
    private double cost;
    private String systemName;

    private CustomerDevice(UUID id, double cost, String systemName) {
        this.id = id;
        this.cost = cost;
        this.systemName = systemName;
    }

    protected CustomerDevice(){

    }

    public static CustomerDevice create(UUID id, double cost, String systemName) {
        return new CustomerDevice(id, cost, systemName);
    }
}
