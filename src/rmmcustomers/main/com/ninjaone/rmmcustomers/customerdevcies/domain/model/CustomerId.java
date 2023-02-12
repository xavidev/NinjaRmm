package com.ninjaone.rmmcustomers.customerdevcies.domain.model;

import com.ninjaone.shared.domain.StringValue;

public class CustomerId extends StringValue {
    public CustomerId(String value) {
        super(value);
    }

    protected CustomerId() {
        super("");
    }
}
