package com.ninjaone.rmm.costs.domain;

import com.ninjaone.rmm.costs.domain.model.DeviceCost;

public interface DeviceCostRepository {
    void save(DeviceCost deviceCost);
}
