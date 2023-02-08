package com.ninjaone.rmm.services.domain.model;

import java.util.Objects;

public abstract class ServiceCostPolicy {

    public ServiceCostPolicy(String policy) {
        this.policy = policy;
    }

    protected ServiceCostPolicy(){

    }

    private String policy;

    public String getPolicy(){
        return policy;
    }
}

