package com.ninjaone.apps.rmm.controller.health_check;

import com.ninjaone.apps.rmm.RmmApplicationTestCase;
import org.junit.jupiter.api.Test;

public class HealthCheckGetControllerShould extends RmmApplicationTestCase {
    @Test
    void check_health_status() throws Exception {
        this.getRequest("/health-check", 200, "{'status': 'ok'}");
    }
}
