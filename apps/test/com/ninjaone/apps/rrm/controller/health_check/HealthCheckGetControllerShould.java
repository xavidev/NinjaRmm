package com.ninjaone.apps.rrm.controller.health_check;

import com.ninjaone.apps.rrm.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

public class HealthCheckGetControllerShould extends RequestTestCase {
    @Test
    void check_health_status() throws Exception {
        this.getRequest("/health-check", 200, "{'status': 'ok'}");
    }
}
