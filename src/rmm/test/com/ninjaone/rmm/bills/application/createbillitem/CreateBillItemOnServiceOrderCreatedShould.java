package com.ninjaone.rmm.bills.application.createbillitem;

import com.ninjaone.rmm.bills.BillsModuleUnitTestCase;
import com.ninjaone.rmm.bills.domain.BillItemMother;
import com.ninjaone.rmm.devices.application.DeviceResponseMother;
import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.rmm.devices.domain.DeviceInformationMother;
import com.ninjaone.rmm.devices.domain.DeviceOrderMother;
import com.ninjaone.rmm.orders.domain.ServiceOrderMother;
import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import com.ninjaone.shared.domain.ServiceOrderCreatedDomainEventMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateBillItemOnServiceOrderCreatedShould extends BillsModuleUnitTestCase {

    private CreateBillItemOnServiceOrderCreated subject;

    @BeforeEach
    public void setUp() {
        super.setUp();

        subject = new CreateBillItemOnServiceOrderCreated(new BillItemCreator(billItemRepository, queryBus, calculator));
    }

    @Test
    void should_create_bill_item_for_service_order(){

        var device = DeviceInformationMother.Windows();
        var service = ServiceInformationMother.antivirus("110");

        var event = ServiceOrderCreatedDomainEventMother.from(
            DeviceOrderMother.from(device),
            ServiceOrderMother.from(service, device.id())
        );

        shouldAsk(new FindDeviceByIdQuery(event.deviceId()), DeviceResponseMother.fromDevice(device));

//        shouldCalculatePriceForService(service.cost());

        subject.on(event);

        shouldHaveSaved(BillItemMother.fromService(event.aggregateId(), service, event.customerId()));
    }
}
