package com.ninjaone.rmmcustomers.customerdevcies.application.updatecost;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bills.BillItemCreatedDomainEvent;
import com.ninjaone.shared.domain.bus.event.DomainEventSubscriber;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({BillItemCreatedDomainEvent.class})
public final class UpdateDeviceCostOnBillItemCreated {

    private final DeviceCostUpdater costUpdater;

    public UpdateDeviceCostOnBillItemCreated(DeviceCostUpdater costUpdater) {
        this.costUpdater = costUpdater;
    }

    @EventListener
    public void on(BillItemCreatedDomainEvent event){
        costUpdater.update(event.aggregateId(), event.cost(), event.itemType(), event.concept());
    }
}
