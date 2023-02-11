package com.ninjaone.rmm.orders.application.create;

import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.orders.create.CreateServiceOrderCommand;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.shared.domain.*;

public final class CreateServiceOrderCommandMother {
    public static CreateServiceOrderCommand random() {
        return new CreateServiceOrderCommand(
            OrderIdMother.random(),
            ServiceIdMother.random(),
            DeviceIdMother.random(),
            CustomerIdMother.random());
    }

    public static CreateServiceOrderCommand from(ServiceInformation service, DeviceInformation device) {
        return new CreateServiceOrderCommand(
            OrderIdMother.random(),
            service.id(),
            device.id(),
            CustomerIdMother.random());
    }
}
