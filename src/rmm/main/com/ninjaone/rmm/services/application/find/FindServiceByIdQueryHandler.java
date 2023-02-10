package com.ninjaone.rmm.services.application.find;

import com.ninjaone.rmm.services.application.ServiceResponse;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryHandler;


@Service
public final class FindServiceByIdQueryHandler implements QueryHandler<FindServiceByIdQuery, ServiceResponse> {

    private final ServiceFinder finder;

    public FindServiceByIdQueryHandler(ServiceFinder finder) {
        this.finder = finder;
    }

    @Override
    public ServiceResponse handle(FindServiceByIdQuery query) {
        return finder.find(query.id());
    }
}
