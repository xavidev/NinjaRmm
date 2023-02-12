package com.ninjaone.rmm.bills.domain.model;

import com.ninjaone.shared.domain.bills.BillItemCreatedDomainEvent;
import com.ninjaone.shared.domain.AggregateRoot;
import com.ninjaone.shared.domain.Price;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillItem billItem = (BillItem) o;
        return Objects.equals(id, billItem.id) && Objects.equals(info, billItem.info) && Objects.equals(price, billItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info, price);
    }
}
