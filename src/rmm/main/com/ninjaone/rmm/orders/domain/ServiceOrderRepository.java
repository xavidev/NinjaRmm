package com.ninjaone.rmm.orders.domain;

import com.ninjaone.rmm.orders.domain.model.ServiceOrder;

public interface ServiceOrderRepository {
    void save(ServiceOrder service);
}
