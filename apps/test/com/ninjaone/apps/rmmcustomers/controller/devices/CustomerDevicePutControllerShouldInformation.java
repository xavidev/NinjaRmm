package com.ninjaone.apps.rmmcustomers.controller.devices;

import com.ninjaone.apps.ApplicationTestCase;
import org.junit.jupiter.api.Test;

class CustomerDevicePutControllerShouldInformation extends ApplicationTestCase {

    @Test
    void create_customer_device() throws Exception {

        var body = """
            {"deviceId":"6750f41a-fe05-48ec-9d2a-c8246733ec4c", "customerId":"c0d2747b-bdcb-4dea-8924-66209dca95fd"}
            """;
        assertRequestWithBody("PUT", "/devices/322d91b8-441e-48f3-b223-ecc01eeb517d", body, CREATED);
    }

}
