package com.ninjaone.rmm.devices.application.delete;

import com.ninjaone.rmm.devices.DevicesModuleUnitTestCase;
import com.ninjaone.rmm.devices.domain.DeviceMother;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteDeviceCommandHandlerShouldInformation extends DevicesModuleUnitTestCase {
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
        DeviceInformation deviceInformation = DeviceMother.Windows();

        shouldSearch(deviceInformation);

        handler.handle(new DeleteDeviceCommand(deviceInformation.id()));

        shouldDelete(deviceInformation);
    }

    @Test
    void not_delete_not_existent_device() {
        DeviceInformation deviceInformation = DeviceMother.Windows();

        handler.handle(new DeleteDeviceCommand(deviceInformation.id()));

        shouldNotDelete(deviceInformation);
    }
}
