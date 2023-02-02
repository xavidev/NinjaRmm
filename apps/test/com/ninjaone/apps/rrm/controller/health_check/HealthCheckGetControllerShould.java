package com.ninjaone.apps.rrm.controller.health_check;

import com.ninjaone.apps.rrm.controller.ApplicationTestCase;
import org.junit.jupiter.api.Test;

public class HealthCheckGetControllerShould extends ApplicationTestCase {
    @Test
    void check_health_status() throws Exception {
        this.getRequest("/health-check", 200, "{'status': 'ok'}");
    }
}
