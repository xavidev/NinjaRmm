package com.ninjaone.rmm.services.application.find;

import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.rmm.devices.application.find.DeviceFinder;
import com.ninjaone.rmm.devices.application.find.FindDeviceByIdQuery;
import com.ninjaone.rmm.services.application.ServiceResponse;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryHandler;

@Service
public final class FindServiceByIdQueryHandler implements QueryHandler<FindServiceByIdQuery, ServiceResponse> {

    private final DeviceFinder finder;

    public FindServiceByIdQueryHandler(DeviceFinder finder) {
        this.finder = finder;
    }

    @Override
    public DeviceResponse handle(FindDeviceByIdQuery query) {
        return finder.find(query.deviceId());
    }
}
