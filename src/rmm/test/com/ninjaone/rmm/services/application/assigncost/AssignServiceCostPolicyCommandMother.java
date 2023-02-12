package com.ninjaone.rmm.services.application.assigncost;


import com.ninjaone.shared.domain.UuidMother;

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

    public static AssignServiceCostPolicyCommand invalid() {
        return new AssignServiceCostPolicyCommand(
            UuidMother.random(),
            "INVALID",
            "{\n" +
                "    \"device\":\"WIN\",\n" +
                "    \"cost\":\"20\"\n" +
                "}");
    }

    public static AssignServiceCostPolicyCommand malFormed() {
        return new AssignServiceCostPolicyCommand(
            UuidMother.random(),
            "PER_DEVICE_TYPE",
            "{\n" +
                "    \"one\":\"WIN\",\n" +
                "    \"two\":\"20\"\n" +
                "}");
    }
}
