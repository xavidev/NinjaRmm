package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.apps.rmm.controller.ApplicationTestCase;
import org.junit.jupiter.api.Test;

class ServiceCostPutControllerShould extends ApplicationTestCase {

    @Test
    void asign_cost_to_an_existent_service() throws Exception {
        var service = """
            {"name":"random"}
            """;
        var cost = """
            {"deviceType":"MAC", "cost":"10"}
            """;

        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d", service, CREATED);
        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d/cost/e3a99bf0-441c-4877-8356-cbe8629583d5", cost, CREATED);
    }

}
