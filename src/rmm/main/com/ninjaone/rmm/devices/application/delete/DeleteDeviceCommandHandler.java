package com.ninjaone.rmm.devices.application.delete;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.command.CommandHandler;

@Service
public final class DeleteDeviceCommandHandler implements CommandHandler<DeleteDeviceCommand> {

    private final DeviceDeleter deleter;

    public DeleteDeviceCommandHandler(DeviceDeleter deleter) {
        this.deleter = deleter;
    }

    @Override
    public void handle(DeleteDeviceCommand command) {
        deleter.delete(command.id());
    }
}
