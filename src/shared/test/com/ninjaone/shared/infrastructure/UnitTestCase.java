package com.ninjaone.shared.infrastructure;

import com.ninjaone.shared.domain.UuidGenerator;
import com.ninjaone.shared.domain.bus.query.Query;
import com.ninjaone.shared.domain.bus.query.QueryBus;
import com.ninjaone.shared.domain.bus.query.QueryHandlerExecutionError;
import com.ninjaone.shared.domain.bus.query.Response;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class UnitTestCase {

    protected QueryBus queryBus;
    protected UuidGenerator uuidGenerator;

    @BeforeEach
    protected void setUp() {
        queryBus = mock(QueryBus.class);
        uuidGenerator = mock(UuidGenerator.class);
    }

    public void shouldGenerateUuid(String uuid) {
        when(uuidGenerator.generate()).thenReturn(uuid);
    }

    public void shouldAsk(Query query, Response response) {
        when(queryBus.ask(query)).thenReturn(response);
    }

    public void shouldThrowWhenAskFor(Query query) {
        when(queryBus.ask(query)).thenThrow(QueryHandlerExecutionError.class);
    }
}
