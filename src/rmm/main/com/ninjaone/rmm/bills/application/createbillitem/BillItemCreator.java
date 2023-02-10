package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.bills.domain.BillItemRepository;
import com.ninjaone.rmm.bills.domain.model.BillItemId;
import com.ninjaone.rmm.bills.domain.model.BillItemInfo;
import com.ninjaone.rmm.bills.domain.model.BillItem;
import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.EventBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;

import java.math.BigDecimal;

@Service
public final class BillItemCreator {

    private final BillItemRepository repository;
    private final QueryBus bus;

    public BillItemCreator(BillItemRepository repository, QueryBus bus){
        this.repository = repository;
        this.bus = bus;
    }

    public void create(String id, String deviceId, String customerId, String concept, String itemType) {
        DeviceResponse response = bus.ask(new FindDeviceByIdQuery(deviceId));

        BillItem item = BillItem.create(
            new BillItemId(id),
            new BillItemInfo(concept, itemType, customerId),
            new Price(String.valueOf(response.cost())));

        repository.save(item);
    }
}
