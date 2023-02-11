package com.ninjaone.rmm.bills.domain.costcalculation;

import java.util.UUID;

public final class CalculationParamsMother {
    public static CalculationParams forDevice(String device) {
        return new CalculationParams(
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            device);
    }
}
