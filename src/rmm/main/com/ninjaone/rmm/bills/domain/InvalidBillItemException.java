package com.ninjaone.rmm.bills.domain;

import com.ninjaone.shared.domain.DomainException;

public final class InvalidBillItemException extends DomainException {

    public InvalidBillItemException(String orderId) {
        super("invalid_bill_item", String.format("The invoice item for the order <%s >could not be processed", orderId));
    }
}
