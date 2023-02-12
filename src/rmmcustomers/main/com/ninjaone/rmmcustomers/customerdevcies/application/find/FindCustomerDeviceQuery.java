package com.ninjaone.rmmcustomers.customerdevcies.application.find;

import com.ninjaone.shared.domain.bus.query.Query;

public final class FindCustomerDeviceQuery implements Query {
    private String orderId;
    private String customerId;

    public FindCustomerDeviceQuery(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public String deviceId() {
        return orderId;
    }

    public String customerId() {
        return customerId;
    }
}
