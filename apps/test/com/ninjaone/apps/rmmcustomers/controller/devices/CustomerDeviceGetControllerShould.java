package com.ninjaone.apps.rmmcustomers.controller.devices;

import com.ninjaone.apps.rmmcustomers.CustomersApplicationTestCase;
import com.ninjaone.rmm.orders.domain.DeviceOrderCreatedDomainEvent;
import com.ninjaone.shared.domain.UuidMother;
import org.junit.jupiter.api.Test;

class CustomerDeviceGetControllerShould extends CustomersApplicationTestCase {
    @Test
    void get_customer_device_when_customer_device_order_is_created() throws Exception {

        var deviceOrderId = UuidMother.random();
        var deviceId = UuidMother.random();
        var customerId = UuidMother.random();

        givenISendEventsToTheBus(new DeviceOrderCreatedDomainEvent(
            deviceOrderId,
            deviceId,
            customerId,
            "Windows device"
        ));

        var expectedResponse = """
            {"systemName":"random", "deviceType":"Windows device", "services":[], "totalCost":"0"}
            """;

        getRequest(
            "/customers/" + customerId + "/devices/" + deviceOrderId + "/detail",
            OK,
            expectedResponse
        );
    }
}
