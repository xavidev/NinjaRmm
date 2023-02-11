package com.ninjaone.apps.rmmcustomers.controller.orders;

import com.ninjaone.apps.rmmcustomers.CustomersApplicationTestCase;
import com.ninjaone.rmm.devices.application.create.CreateDeviceInformationCommand;
import com.ninjaone.rmm.services.application.create.CreateServiceInformationCommand;
import org.junit.jupiter.api.Test;

class CustomerServiceOrderPutControllerShould extends CustomersApplicationTestCase {

    @Test
    void should_create_new_device_and_service_order_for_existent_service_and_device() throws Exception {

        var serviceId = "322d91b8-441e-48f3-b223-ecc01eeb517d";
        var deviceId = "322d91b8-441e-48f3-b223-ecc01eeb517d";

        givenISendCommandToTheBus(new CreateDeviceInformationCommand(
            deviceId,
            "test type",
            "50"
        ));

        givenISendCommandToTheBus(new CreateServiceInformationCommand(
            serviceId,
            "test service",
            "250"
        ));

        var deviceOrder = """
            {"customerId":"caa5c9ff-65b9-4f98-a3c3-043f4b2fa15e"}
            """;
        assertRequestWithBody(
            "PUT",
            "/orders/31bf6a3c-2d59-4f87-801f-945fe101bd50/devices/322d91b8-441e-48f3-b223-ecc01eeb517d",
            deviceOrder,
            CREATED);

        var serviceOrder = """
            {"deviceId":"322d91b8-441e-48f3-b223-ecc01eeb517d", "customerId":"caa5c9ff-65b9-4f98-a3c3-043f4b2fa15e"}
            """;
        assertRequestWithBody(
            "PUT",
            "/orders/98e9d96a-686a-4b07-800a-b4415ba08efb/service/322d91b8-441e-48f3-b223-ecc01eeb517d",
            serviceOrder,
            CREATED);
    }
}
