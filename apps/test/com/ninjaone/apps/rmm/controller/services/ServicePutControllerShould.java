package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.apps.rmm.controller.ApplicationTestCase;
import org.junit.jupiter.api.Test;

public class ServicePutControllerShould extends ApplicationTestCase {

    @Test
    void create_non_existing_valid_service() throws Exception {

        var body = """
            {"name":"random"}
            """;
        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d", body, 201);
    }
}
