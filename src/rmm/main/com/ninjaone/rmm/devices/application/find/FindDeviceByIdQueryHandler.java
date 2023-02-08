package com.ninjaone.rmm.devices.application.find;

import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryHandler;

@Service
public final class FindDeviceByIdQueryHandler implements QueryHandler<FindDeviceByIdQuery, DeviceResponse> {

    private final DeviceFinder finder;

    public FindDeviceByIdQueryHandler(DeviceFinder finder) {
        this.finder = finder;
    }

    @Override
    public DeviceResponse handle(FindDeviceByIdQuery query) {
        return finder.find(query.deviceId());
    }
}
