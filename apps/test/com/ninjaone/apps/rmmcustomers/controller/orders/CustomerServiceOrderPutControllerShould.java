package com.ninjaone.apps.rmmcustomers.controller.orders;

import com.ninjaone.apps.rmmcustomers.CustomersApplicationTestCase;
import org.junit.jupiter.api.Test;

class CustomerServiceOrderPutControllerShould extends CustomersApplicationTestCase {

    @Test
    void should_create_new_service_order_for_existent_service_and_device() throws Exception {
        var serviceRequest = """
            {"name":"random", "cost":"50"}
            """;
        assertRequestWithBody(
            "PUT",
            "/services/322d91b8-441e-48f3-b223-ecc01eeb517d",
            serviceRequest,
            CREATED);

        var deviceRequest = """
            {"type":"Windows", "cost":"20"}
            """;
        assertRequestWithBody("PUT", "/devices/322d91b8-441e-48f3-b223-ecc01eeb517d", deviceRequest, CREATED);

        var orderRequest = """
            {"deviceId":"322d91b8-441e-48f3-b223-ecc01eeb517d", "customerId":"caa5c9ff-65b9-4f98-a3c3-043f4b2fa15e"}
            """;
        assertRequestWithBody(
            "PUT",
            "/orders/98e9d96a-686a-4b07-800a-b4415ba08efb/service/322d91b8-441e-48f3-b223-ecc01eeb517d",
            orderRequest,
            CREATED);
    }
}
