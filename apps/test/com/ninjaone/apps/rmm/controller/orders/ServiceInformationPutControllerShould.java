package com.ninjaone.apps.rmm.controller.orders;

import com.ninjaone.apps.ApplicationTestCase;
import org.junit.jupiter.api.Test;

class ServiceInformationPutControllerShould extends ApplicationTestCase {

    @Test
    void should_create_new_service_order_for_existent_service_and_device() throws Exception {
        var serviceRequest = """
            {"name":"random", "price":"50"}
            """;
        assertRequestWithBody(
            "PUT",
            "/services/322d91b8-441e-48f3-b223-ecc01eeb517d",
            serviceRequest,
            CREATED);

        var deviceRequest = """
            {"type":"Windows", "price":"20"}
            """;
        assertRequestWithBody("PUT", "/devices/322d91b8-441e-48f3-b223-ecc01eeb517d", deviceRequest, CREATED);

        var orderRequest = """
            {"deviceId":"322d91b8-441e-48f3-b223-ecc01eeb517d", "customerId":"1"}
            """;
        assertRequestWithBody(
            "PUT",
            "/services/322d91b8-441e-48f3-b223-ecc01eeb517d/order/0f91e69d-ed92-482f-aefb-fc54046ad05b",
            orderRequest,
            CREATED);
    }
}
