package com.ninjaone.rmmcustomers.customerdevcies.domain;

import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDeviceId;
import com.ninjaone.shared.domain.DomainException;

public final class CustomerDeviceNotExistException extends DomainException {
    public CustomerDeviceNotExistException(CustomerDeviceId id) {
        super(
            "customer_device_not_exist",
            String.format("The customer device associated to order <%s> not exist", id.value()));
    }
}
