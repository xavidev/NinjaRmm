package com.ninjaone.apps.rrm.controller.services;

import com.ninjaone.apps.rrm.controller.ApplicationTestCase;
import org.junit.jupiter.api.Test;

public class ServicePutControllerShould extends ApplicationTestCase {

    @Test
    void create_non_existing_valid_service() throws Exception {

        var body = """
            {"name":"random", "prices":[{"dtype":"MAC", "price":"10"}, {"dtype":"WIN", "price":"5"}, {"dtype":"ANY", "price":"3"}]}
            """;
        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d", body, 201);
    }
}
