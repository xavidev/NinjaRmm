package com.ninjaone.rmm.orders.domain;

import com.ninjaone.rmm.orders.create.CreateServiceOrderCommand;
import com.ninjaone.rmm.orders.domain.model.OrderName;
import com.ninjaone.rmm.orders.domain.model.ServiceOrder;
import com.ninjaone.rmm.orders.domain.model.ServiceOrderId;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.shared.domain.UuidMother;
import com.ninjaone.shared.domain.CustomerId;
import com.ninjaone.shared.domain.DeviceId;
import com.ninjaone.shared.domain.ServiceId;

public final class ServiceOrderMother {
    public static ServiceOrder fromCommand(CreateServiceOrderCommand command){
        return ServiceOrder.create(
            new ServiceOrderId(command.orderId()),
            new ServiceId(command.serviceId()),
            new OrderName("order"),
            new DeviceId(command.deviceId()),
            new CustomerId(command.customerId())
        );
    }

    public static ServiceOrder random() {
        return ServiceOrder.create(
            new ServiceOrderId(UuidMother.random()),
            new ServiceId(UuidMother.random()),
            new OrderName("order"),
            new DeviceId(UuidMother.random()),
            new CustomerId(UuidMother.random())
        );
    }


    public static ServiceOrder from(ServiceInformation service, String deviceId) {
        return ServiceOrder.create(
            new ServiceOrderId(UuidMother.random()),
            new ServiceId(service.id()),
            new OrderName(service.name()),
            new DeviceId(deviceId),
            new CustomerId(UuidMother.random())
            );
    }
}

