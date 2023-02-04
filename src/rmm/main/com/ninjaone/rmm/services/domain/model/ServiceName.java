package com.ninjaone.rmm.services.domain.model;

import com.ninjaone.shared.domain.StringValue;

public class ServiceName extends StringValue {
    public ServiceName(String name) {

        super(name);
    }

    private ServiceName(){
        super("");
    }
}
