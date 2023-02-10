package com.ninjaone.rmm.bills.domain.model;

import com.ninjaone.rmm.bills.domain.BillItemCreatedDomainEvent;
import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.Price;

import java.math.BigDecimal;

public class BillItem extends AggregateRoot {
    private BillItemId id;
    private BillItemInfo info;
    private Price price;

    protected BillItem(){

    }

    private BillItem(BillItemId id, BillItemInfo billItemInfo, Price price) {

        this.id = id;
        this.info = billItemInfo;
        this.price = price;

        record(new BillItemCreatedDomainEvent(id.value(), info.customerId(), info.concept(), price.toString()));
    }

    public static BillItem create(BillItemId id, BillItemInfo info, Price price) {
        return new BillItem(id, info, price);
    }

    public String concept() {
        return info.concept();
    }

    public BigDecimal cost() {
        return price.value();
    }
}
