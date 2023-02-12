package com.ninjaone.rmmcustomers.customerdevcies.domain.model;

import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.Price;

import java.util.List;

public class CustomerDevice extends AggregateRoot {

    private CustomerDeviceId id;
    private SystemName systemName;
    private DeviceType type;

    private List<CustomerService> services;

    private Price totalCost;

    private CustomerDevice(CustomerDeviceId id, SystemName systemName, DeviceType type, Price totalCost) {
        this.systemName = systemName;
        this.type = type;
        this.totalCost = totalCost;
    }

    protected CustomerDevice(){

    }

    public CustomerDevice create(CustomerDeviceId id, SystemName systemName, DeviceType type, Price totalCost){
        return new CustomerDevice(id, systemName, type, totalCost);
    }
}
