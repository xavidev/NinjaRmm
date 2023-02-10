package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.bills.BillsModuleUnitTestCase;
import com.ninjaone.rmm.bills.domain.BillItemMother;
import com.ninjaone.rmm.devices.application.DeviceResponseMother;
import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.devices.domain.DeviceOrderMother;
import com.ninjaone.rmm.orders.domain.DeviceOrderCreatedDomainEvent;
import com.ninjaone.rmm.shared.domain.DeviceOrderCreatedDomainEventMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CreateBillItemOnDeviceOrderCreatedShould extends BillsModuleUnitTestCase {

    private CreateBillItemOnDeviceOrderCreated subject;

    @BeforeEach
    public void setUp() {
        super.setUp();

        subject = new CreateBillItemOnDeviceOrderCreated(new BillItemCreator(billItemRepository, queryBus));
    }

    @Test
    void should_create_bill_item_with_device_cost(){

        var device = DeviceMother.Windows();

        var event = DeviceOrderCreatedDomainEventMother.from(DeviceOrderMother.from(device));

        var deviceResponse = DeviceResponseMother.fromDevice(device);

        shouldAsk(new FindDeviceByIdQuery(event.deviceId()), deviceResponse);

        subject.on(event);

        shouldHaveSaved(BillItemMother.fromDevice(event.aggregateId(), device, event.customerId()));
    }
}
