package com.ninjaone.rmmcustomers.customerdevcies.domain.model;

import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.Price;

import java.util.ArrayList;
import java.util.List;

public class CustomerDevice extends AggregateRoot {

    private CustomerDeviceId id;
    private SystemName systemName;
    private DeviceType type;

    private List<CustomerService> services;

    private Price totalCost;

    private CustomerDevice(CustomerDeviceId id, SystemName systemName, DeviceType type, Price totalCost) {
        this.id = id;
        this.systemName = systemName;
        this.type = type;
        this.totalCost = totalCost;
        this. services = new ArrayList<>();
    }

    protected CustomerDevice(){

    }

    public static CustomerDevice create(CustomerDeviceId id, SystemName systemName, DeviceType type){
        return new CustomerDevice(id, systemName, type, new Price("0"));
    }

    public void addService(CustomerService service) {
        this.services.add(service);
    }

    public void updateCost(Price price) {
        this.totalCost = totalCost.plus(price);
    }

    public CustomerDeviceId id() {
        return id;
    }

    public SystemName systemName() {
        return systemName;
    }

    public DeviceType type() {
        return type;
    }

    public List<CustomerService> services() {
        return services;
    }

    public Price totalCost() {
        return totalCost;
    }
}
