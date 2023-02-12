package com.ninjaone.rmmcustomers.customerdevcies.application.explanation;

import com.ninjaone.shared.domain.bus.query.Query;

public final class CustomerDeviceExplanationQuery implements Query {
    private String customerId;

    public CustomerDeviceExplanationQuery(String customerId) {

        this.customerId = customerId;
    }

    public String customerId() {
        return customerId;
    }
}
