package com.ninjaone.shared.domain.bus.query;

public final class QueryNotRegisteredError extends Throwable {
    public QueryNotRegisteredError(Class<? extends Query> query) {
        super(String.format("The query <%s> hasn't a query handler associated", query.toString()));
    }
}
