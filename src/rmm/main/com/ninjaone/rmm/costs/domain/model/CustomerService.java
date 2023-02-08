package com.ninjaone.rmm.costs.domain.model;

public class CustomerService {
    private String name;
    private String customerId;
    private String serviceInfoId;

    private double count;

    private CustomerService() {
    }

    public CustomerService(String name, String customerId, String serviceInfoId) {
        this.name = name;
        this.customerId = customerId;
        this.serviceInfoId = serviceInfoId;
    }

    public String infoId(){
        return serviceInfoId;
    }
}
