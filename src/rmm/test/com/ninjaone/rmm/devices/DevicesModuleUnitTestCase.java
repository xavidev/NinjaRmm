package com.ninjaone.rmm.devices;

import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.rmm.devices.domain.model.Device;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class DevicesModuleUnitTestCase {

    protected DeviceRepository repository;
    @BeforeEach
    protected void setUp(){
        repository = mock(DeviceRepository.class);
    }

    protected void shouldHaveSaved(Device device) {
        verify(repository, atLeastOnce()).save(device);
    }
}
