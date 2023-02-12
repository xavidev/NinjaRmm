package com.ninjaone.rmmcustomers.customerdevcies.domain.model;

public class CustomerService {
    private String id;
    private String name;

    public CustomerService(String id, String name) {
        this.id = id;
        this.name = name;
    }

    protected CustomerService() {

    }

    public String name() {
        return name;
    }
}
