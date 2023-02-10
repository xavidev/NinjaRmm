package com.ninjaone.rmm.bills.domain.model;

import com.ninjaone.shared.domain.DomainException;

public final class NoItemsToBillException extends DomainException {
    public NoItemsToBillException(String customerId) {
        super("no_items_to_bill", String.format("There is not items to bill for customer <%s>", customerId));
    }
}
