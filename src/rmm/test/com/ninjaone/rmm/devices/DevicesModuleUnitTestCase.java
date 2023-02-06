package com.ninjaone.rmm.devices;

import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.rmm.devices.domain.model.Device;
import com.ninjaone.rmm.devices.domain.model.DeviceId;
import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class DevicesModuleUnitTestCase extends UnitTestCase {

    protected DeviceRepository repository;
    @BeforeEach
    protected void setUp(){
        repository = mock(DeviceRepository.class);
    }

    public void shouldSearch(Device device) {
        Mockito.when(repository.search(new DeviceId(device.id()))).thenReturn(Optional.of(device));
    }

    protected void shouldHaveSaved(Device device) {
        verify(repository, atLeastOnce()).save(device);
    }

    protected void shouldDelete(Device device) {
        verify(repository, atLeastOnce()).delete(device);
    }

    protected void shouldNotDelete(Device device) {
        verify(repository, never()).delete(device);
    }
}
