package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.bills.domain.BillItemRepository;
import com.ninjaone.rmm.bills.domain.model.BillItemId;
import com.ninjaone.rmm.bills.domain.model.BillItemInfo;
import com.ninjaone.rmm.bills.domain.model.BillItem;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.EventBus;

import java.math.BigDecimal;

@Service
public final class BillItemCreator {

    private final BillItemRepository repository;
    private final EventBus bus;

    public BillItemCreator(BillItemRepository repository, EventBus bus){
        this.repository = repository;
        this.bus = bus;
    }

    public void create(String id, String customerId, String concept, String itemType) {
        String cost = "0";

        BillItem item = BillItem.create(
            new BillItemId(id),
            new BillItemInfo(concept, itemType, customerId),
            new Price(cost));

//        repository.save(item);

        bus.publish(item.pullDomainEvents());
    }
}
