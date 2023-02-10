package com.ninjaone.rmm.devices;

import com.ninjaone.rmm.devices.domain.DeviceInformationRepository;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.shared.domain.DeviceId;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class DevicesModuleUnitTestCase extends UnitTestCase {

    protected DeviceInformationRepository repository;
    @BeforeEach
    protected void setUp(){
        repository = mock(DeviceInformationRepository.class);
    }

    public void shouldSearch(DeviceInformation deviceInformation) {
        Mockito.when(repository.search(new DeviceId(deviceInformation.id()))).thenReturn(Optional.of(deviceInformation));
    }

    protected void shouldHaveSaved(DeviceInformation deviceInformation) {
        verify(repository, atLeastOnce()).save(deviceInformation);
    }

    protected void shouldDelete(DeviceInformation deviceInformation) {
        verify(repository, atLeastOnce()).delete(deviceInformation);
    }

    protected void shouldNotDelete(DeviceInformation deviceInformation) {
        verify(repository, never()).delete(deviceInformation);
    }
}
