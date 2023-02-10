package com.ninjaone.apps.rmm.controller.devices;

import com.ninjaone.apps.ApplicationTestCase;
import org.junit.jupiter.api.Test;

class DeviceInformationPutControllerShould extends ApplicationTestCase {

    @Test
    void create_non_existing_valid_device() throws Exception {

        var body = """
            {"type":"Windows", "price":"20"}
            """;
        assertRequestWithBody("PUT", "/devices/322d91b8-441e-48f3-b223-ecc01eeb517d", body, CREATED);
    }
}
