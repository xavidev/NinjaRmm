package com.ninjaone.rmm.services;

import com.ninjaone.rmm.services.domain.DeviceServiceRepository;
import com.ninjaone.rmm.services.domain.model.DeviceService;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public abstract class ServicesModuleUnitTestCase {
    protected DeviceServiceRepository repository;

    @BeforeEach
    protected void setUp(){
        repository = mock(DeviceServiceRepository.class);
    }

    public void shouldHaveSaved(DeviceService service) {
        verify(repository, atLeastOnce()).save(service);
    }
}
