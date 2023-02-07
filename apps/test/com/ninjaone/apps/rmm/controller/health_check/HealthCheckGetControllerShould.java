package com.ninjaone.apps.rmm.controller.health_check;

import com.ninjaone.apps.ApplicationTestCase;
import org.junit.jupiter.api.Test;

public class HealthCheckGetControllerShould extends ApplicationTestCase {
    @Test
    void check_health_status() throws Exception {
        this.getRequest("/health-check", 200, "{'status': 'ok'}");
    }
}
