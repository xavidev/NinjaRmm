package com.ninjaone.rmm.services.application.assigncost;

import com.ninjaone.rmm.shared.domain.UuidMother;

public final class AssignServiceCostPolicyCommandMother {
    public static AssignServiceCostPolicyCommand perDeviceType() {
        return new AssignServiceCostPolicyCommand(
            UuidMother.random(),
            "PER_DEVICE_TYPE",
            "{\n" +
                "    \"device\":\"WIN\",\n" +
                "    \"cost\":\"20\"\n" +
                "}");
    }
}
