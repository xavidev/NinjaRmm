package com.ninjaone.rmmcustomers.customerdevcies.domain.model;

import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.Price;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerDevice extends AggregateRoot {

    private CustomerDeviceId id;
    private SystemName systemName;
    private DeviceType type;
    private CustomerId customerId;

    private Price deviceCost;
    private List<CustomerService> services;

    private Price totalCost;

    private CustomerDevice(CustomerDeviceId id, SystemName systemName, DeviceType type, CustomerId customerId) {
        this.id = id;
        this.systemName = systemName;
        this.type = type;
        this.customerId = customerId;
        this.services = new ArrayList<>();
        this.deviceCost = new Price("0");
        this.totalCost = new Price("0");
    }

    protected CustomerDevice() {

    }

    public static CustomerDevice create(CustomerDeviceId id, SystemName systemName, DeviceType type, CustomerId customerId) {
        return new CustomerDevice(id, systemName, type, customerId);
    }

    public void addService(CustomerService service) {
        this.services.add(service);
        this.totalCost = totalCost.plus(service.cost());
    }

    public void setDeviceCost(Price price) {
        this.deviceCost = deviceCost.plus(price);
        this.totalCost = new Price(String.valueOf(deviceCost.value()));
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

    public String customerId() {
        return customerId.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDevice that = (CustomerDevice) o;
        return Objects.equals(id, that.id) && Objects.equals(systemName, that.systemName) && Objects.equals(type, that.type) && Objects.equals(customerId, that.customerId) && Objects.equals(deviceCost, that.deviceCost) && Objects.equals(services, that.services) && Objects.equals(totalCost, that.totalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, systemName, type, customerId, deviceCost, services, totalCost);
    }
}
