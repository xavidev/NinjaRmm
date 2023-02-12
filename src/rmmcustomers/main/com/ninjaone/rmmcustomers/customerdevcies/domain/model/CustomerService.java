package com.ninjaone.rmmcustomers.customerdevcies.domain.model;

import com.ninjaone.shared.domain.Price;

public class CustomerService {
    private String cost;
    private String id;
    private String name;

    public CustomerService(String id, String name, String cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    protected CustomerService() {

    }

    public String name() {
        return name;
    }

    public Price cost() {
        return new Price(cost);
    }
}
