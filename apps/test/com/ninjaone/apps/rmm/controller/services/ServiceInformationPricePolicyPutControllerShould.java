package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.apps.ApplicationTestCase;
import org.junit.jupiter.api.Test;

class ServiceInformationPricePolicyPutControllerShould extends ApplicationTestCase {

    @Test
    void asign_cost_to_an_existent_service() throws Exception {
        var service = """
            {"name":"random"}
            """;
        var price = """
            {"deviceType":"MAC", "price":"10"}
            """;

        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d", service, CREATED);
        assertRequestWithBody("PUT", "/services/322d91b8-441e-48f3-b223-ecc01eeb517d/price", price, CREATED);
    }

}