package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.bills.domain.BillItemRepository;
import com.ninjaone.rmm.bills.domain.InvalidBillItemException;
import com.ninjaone.rmm.bills.domain.model.BillItem;
import com.ninjaone.rmm.bills.domain.model.BillItemId;
import com.ninjaone.rmm.bills.domain.model.BillItemInfo;
import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.shared.domain.Price;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.EventBus;
import com.ninjaone.shared.domain.bus.query.QueryBus;

@Service
public final class DeviceBillItemCreator {

    private final BillItemRepository repository;
    private final QueryBus bus;
    private final EventBus eventBus;

    public DeviceBillItemCreator(BillItemRepository repository, QueryBus bus, EventBus eventBus){
        this.repository = repository;
        this.bus = bus;
        this.eventBus = eventBus;
    }

    public void create(BillCreationParams params) {
        BillItem item;
        DeviceResponse deviceResponse = bus.ask(new FindDeviceByIdQuery(params.getDeviceId()));

        if(params.getItemType().equals("device")){
            Price cost = deviceResponse.cost();
            item = createBill(params, cost);
        } else {
            throw new InvalidBillItemException(params.getOrderId());
        }

        repository.save(item);

        eventBus.publish(item.pullDomainEvents());
    }

    private static BillItem createBill(BillCreationParams params, Price cost) {
        return BillItem.billDevice(
            new BillItemId(params.getOrderId()),
            new BillItemInfo(params.getOrderConcept(), params.getItemType(), params.getCustomerId()),
            new Price(String.valueOf(cost.value())));
    }
}
