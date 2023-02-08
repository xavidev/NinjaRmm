package com.ninjaone.rmmcustomers.bills.application.create;

import com.ninjaone.rmmcustomers.bills.domain.BillItemRepository;
import com.ninjaone.rmmcustomers.bills.domain.model.BillItem;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.EventBus;

@Service
public final class BillItemCreator {

    private final BillItemRepository repository;
    private final EventBus bus;

    public BillItemCreator(BillItemRepository repository, EventBus bus){
        this.repository = repository;
        this.bus = bus;
    }

    public void create(String itemRef, String customerId, String concept, String itemType, double cost) {
        BillItem item = BillItem.create(itemRef, customerId, concept, itemType, cost);

        repository.save(item);

        bus.publish(item.pullDomainEvents());
    }
}
