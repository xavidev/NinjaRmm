package com.ninjaone.rmm.services;

import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.Service;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public abstract class ServicesModuleUnitTestCase {
    protected ServiceRepository repository;

    @BeforeEach
    protected void setUp(){
        repository = mock(ServiceRepository.class);
    }

    public void shouldHaveSaved(Service service) {
        verify(repository, atLeastOnce()).save(service);
    }
}
