package com.ninjaone.rmm.services;

import com.ninjaone.rmm.services.domain.ServiceRepository;
import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

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

    public void shouldSearch(Service service) {
        Mockito.when(repository.search(new ServiceId(service.id()))).thenReturn(Optional.of(service));
    }
}
