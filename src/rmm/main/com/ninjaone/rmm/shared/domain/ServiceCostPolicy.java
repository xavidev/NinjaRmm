package com.ninjaone.rmm.shared.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceCostPolicy {
    protected String serviceName;
    protected String numOfServices;
    protected String discount;
    protected String device;
    protected String cost;

    protected String type;

    protected ServiceCostPolicy(String serviceName, String numOfServices, String discount) {

        this.serviceName = serviceName;
        this.numOfServices = numOfServices;
        this.discount = discount;
        this.device = null;
        this.cost = null;
    }

    protected ServiceCostPolicy(String device, String cost) {

        this.serviceName = null;
        this.numOfServices = null;
        this.discount = null;
        this.device = device;
        this.cost = cost;
    }

    protected ServiceCostPolicy() {

    }

    public String type(){
        return type;
    }

    public String value() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(this);
    }
}

