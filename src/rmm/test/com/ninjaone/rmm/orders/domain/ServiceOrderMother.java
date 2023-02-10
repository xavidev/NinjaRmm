package com.ninjaone.rmm.orders.domain;

import com.ninjaone.rmm.orders.create.CreateServiceOrderCommand;
import com.ninjaone.rmm.orders.domain.model.OrderName;
import com.ninjaone.rmm.orders.domain.model.ServiceOrder;
import com.ninjaone.rmm.orders.domain.model.ServiceOrderId;
import com.ninjaone.shared.domain.CustomerId;
import com.ninjaone.shared.domain.DeviceId;
import com.ninjaone.shared.domain.ServiceId;

public final class ServiceOrderMother {
    public static ServiceOrder fromCommand(CreateServiceOrderCommand command){
        return ServiceOrder.create(
            new ServiceOrderId(command.orderId()),
            new ServiceId(command.serviceId()),
            new DeviceId(command.deviceId()),
            new CustomerId(command.customerId())
        );
    }
}

