package com.ninjaone.rmm.bills.domain.model;

import com.ninjaone.shared.domain.UuidIdentifier;

public final class BillItemId extends UuidIdentifier {
    public BillItemId(String value) {
        super(value);
    }

    private BillItemId() {
    }
}
