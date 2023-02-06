package com.ninjaone.rmm.devices.application.delete;

import com.ninjaone.rmm.devices.DevicesModuleUnitTestCase;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.devices.domain.model.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteDeviceCommandHandlerShould extends DevicesModuleUnitTestCase {
    DeviceDeleter subject;

    DeleteDeviceCommandHandler handler;
    @BeforeEach
    protected void setUp() {
        super.setUp();

        subject = new DeviceDeleter(repository);
        handler = new DeleteDeviceCommandHandler(subject);
    }

    @Test
    void delete_a_device() {
        Device device = DeviceMother.Windows();

        shouldSearch(device);

        handler.handle(new DeleteDeviceCommand(device.id()));

        shouldDelete(device);
    }

    @Test
    void not_delete_not_existent_device() {
        Device device = DeviceMother.Windows();

        handler.handle(new DeleteDeviceCommand(device.id()));

        shouldNotDelete(device);
    }
}
