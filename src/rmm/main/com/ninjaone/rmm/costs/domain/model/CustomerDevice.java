package com.ninjaone.rmm.costs.domain.model;

import java.util.List;
import java.util.stream.Collectors;

public final class CustomerDevice {
    private CustomerDeviceId id;
    private CustomerId customerId;
    private DeviceInformationId informationId;

    private List<CustomerService> customerServices;

    public CustomerDevice(CustomerDeviceId id, CustomerId customerId, DeviceInformationId informationId) {
        this.id = id;
        this.customerId = customerId;
        this.informationId = informationId;
    }

    public void addService(CustomerService service){
        this.customerServices.add(service);
    }

    public void removeService(CustomerService service){
        this.customerServices.remove(service);
    }

    public List<String> services(){
        return customerServices.stream()
            .map(CustomerService::infoId)
            .collect(Collectors.toList());
    }

    public String id() {
        return id.value();
    }
}
