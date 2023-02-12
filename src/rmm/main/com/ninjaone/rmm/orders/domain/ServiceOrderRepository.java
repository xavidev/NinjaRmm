package com.ninjaone.rmm.orders.domain;

import com.ninjaone.rmm.orders.domain.model.ServiceOrder;
import com.ninjaone.rmm.orders.domain.model.ServiceOrderId;

import java.util.Optional;

public interface ServiceOrderRepository {
    void save(ServiceOrder service);

    Optional<ServiceOrder> search(ServiceOrderId serviceOrderId);
}
