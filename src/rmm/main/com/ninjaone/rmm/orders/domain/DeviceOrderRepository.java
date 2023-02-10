package com.ninjaone.rmm.orders.domain;

import com.ninjaone.rmm.orders.domain.model.DeviceOrder;

public interface DeviceOrderRepository {
    void save(DeviceOrder device);
}
