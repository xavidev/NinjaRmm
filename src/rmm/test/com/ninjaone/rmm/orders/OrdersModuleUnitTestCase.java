package com.ninjaone.rmm.orders;

import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.rmm.orders.domain.ServiceOrderRepository;
import com.ninjaone.rmm.orders.domain.model.ServiceOrder;
import com.ninjaone.shared.domain.bus.query.Query;
import com.ninjaone.shared.domain.bus.query.QueryHandlerExecutionError;
import com.ninjaone.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public abstract class OrdersModuleUnitTestCase extends UnitTestCase {
    protected ServiceOrderRepository repository;

    @BeforeEach
    protected void setUp(){
        super.setUp();

        repository = mock(ServiceOrderRepository.class);
    }

    public void shouldHaveSaved(ServiceOrder order) {
        verify(repository, atLeastOnce()).save(order);
    }

    public void shouldNotSave(ServiceOrder order) {
        verify(repository, never()).save(order);
    }
}
