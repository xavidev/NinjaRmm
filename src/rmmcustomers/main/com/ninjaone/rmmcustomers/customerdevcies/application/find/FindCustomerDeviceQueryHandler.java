package com.ninjaone.rmmcustomers.customerdevcies.application.find;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryHandler;

@Service
public final class FindCustomerDeviceQueryHandler implements QueryHandler<FindCustomerDeviceQuery, CustomerDeviceResponse> {

    private CustomerDeviceFinder finder;

    public FindCustomerDeviceQueryHandler(CustomerDeviceFinder finder) {
        this.finder = finder;
    }

    @Override
    public CustomerDeviceResponse handle(FindCustomerDeviceQuery query) {
        return finder.find(query.deviceId(), query.customerId());
    }
}
