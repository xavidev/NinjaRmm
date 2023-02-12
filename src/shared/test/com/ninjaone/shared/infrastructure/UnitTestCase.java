package com.ninjaone.shared.infrastructure;

import com.ninjaone.shared.domain.UuidGenerator;
import com.ninjaone.shared.domain.bus.event.DomainEvent;
import com.ninjaone.shared.domain.bus.event.EventBus;
import com.ninjaone.shared.domain.bus.query.Query;
import com.ninjaone.shared.domain.bus.query.QueryBus;
import com.ninjaone.shared.domain.bus.query.QueryHandlerExecutionError;
import com.ninjaone.shared.domain.bus.query.Response;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public abstract class UnitTestCase {
    protected QueryBus queryBus;

    protected EventBus eventBus;

    protected UuidGenerator uuidGenerator;

    @BeforeEach
    protected void setUp() {
        queryBus = mock(QueryBus.class);
        eventBus = mock(EventBus.class);
        uuidGenerator = mock(UuidGenerator.class);
    }

    public void shouldHavePublished(List<DomainEvent> domainEvents) {
        verify(eventBus, atLeastOnce()).publish(domainEvents);
    }

    public void shouldHavePublished(DomainEvent domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }

    public void shouldAsk(Query query, Response response) {
        when(queryBus.ask(query)).thenReturn(response);
    }

    public void shouldThrowWhenAskFor(Query query) {
        when(queryBus.ask(query)).thenThrow(QueryHandlerExecutionError.class);
    }
}
