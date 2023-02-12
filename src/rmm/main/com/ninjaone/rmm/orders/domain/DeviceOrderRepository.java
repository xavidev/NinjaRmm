package com.ninjaone.rmm.orders.domain;

import com.ninjaone.rmm.orders.domain.model.DeviceOrder;
import com.ninjaone.rmm.orders.domain.model.DeviceOrderId;

import java.util.Optional;

public interface DeviceOrderRepository {
    void save(DeviceOrder device);

    Optional<DeviceOrder> search(DeviceOrderId deviceOrderId);
}
