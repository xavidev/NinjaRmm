package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.apps.rmm.controller.ApplicationTestCase;
import org.junit.jupiter.api.Test;

public class ServicePutControllerShould extends ApplicationTestCase {

    @Test
    void create_non_existing_valid_service() throws Exception {

        var body = """
            {"name":"random"}
            """;
        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d", body, CREATED);
    }

    @Test
    void not_create_existing_service() throws Exception {

        var body = """
            {"name":"random"}
            """;

        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d", body, CREATED);
        assertRequestWithBody("PUT", "/services/5de3c4f3-23c2-4812-8933-99c4ef782197", body, BAD_REQUEST);
    }
}
