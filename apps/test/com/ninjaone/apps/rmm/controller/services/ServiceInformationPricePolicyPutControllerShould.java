package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.apps.rmm.RmmApplicationTestCase;
import org.junit.jupiter.api.Test;

class ServiceCostPolicyPutControllerShould extends RmmApplicationTestCase {

    @Test
    void asign_cost_to_an_existent_service() throws Exception {
        var service = """
            {"name":"random", "cost":"5"}
            """;
        var price = """
            {"type":"PER_DEVICE_TYPE", "value":{"device":"MAC", "cost":"100"}}
            """;

        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d", service, CREATED);
        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d/cost", price, CREATED);
    }

}
