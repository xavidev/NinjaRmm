package com.ninjaone.apps.rmmcustomers.controller.devices;

import com.ninjaone.apps.rmmcustomers.CustomersApplicationTestCase;
import com.ninjaone.rmm.devices.application.create.CreateDeviceInformationCommand;
import com.ninjaone.shared.domain.orders.DeviceOrderCreatedDomainEvent;
import com.ninjaone.shared.domain.UuidMother;
import org.junit.jupiter.api.Test;

class CustomerDeviceGetControllerShould extends CustomersApplicationTestCase {
    @Test
    void get_customer_device_when_customer_device_order_is_created() throws Exception {

        var deviceOrderId = UuidMother.random();
        var deviceId = UuidMother.random();
        var customerId = UuidMother.random();

        givenISendCommandToTheBus(new CreateDeviceInformationCommand(
            deviceId,
            "test type",
            "50"
        ));

        givenISendEventsToTheBus(new DeviceOrderCreatedDomainEvent(
            deviceOrderId,
            deviceId,
            customerId,
            "Windows device"
        ));


        var response = "{\"systemName\":\"Windows device-" + customerId + "\",\"deviceType\":\"Windows device\", \"services\":[], \"totalCost\":\"0\"}";

        getRequest(
            "/customers/" + customerId + "/devices/" + deviceOrderId + "/detail",
            OK,
            response
        );
    }
}
