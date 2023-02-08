package com.ninjaone.rmm.costs.domain.model;

import com.ninjaone.shared.domain.StringValue;

public class DeviceCostId extends StringValue {
    public DeviceCostId(String id) {
        super(id);
    }

    private DeviceCostId(){
        super(null);
    }
}
