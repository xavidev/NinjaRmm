package com.ninjaone.rmm.orders.create;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateDeviceOrderHandler implements CommandHandler<CreateDeviceOrderCommand> {
    private final DeviceOrderCreator creator;

    public CreateDeviceOrderHandler(DeviceOrderCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateDeviceOrderCommand command) {
        creator.create(command.customerDeviceId(), command.deviceId(), command.customerId());
    }
}
