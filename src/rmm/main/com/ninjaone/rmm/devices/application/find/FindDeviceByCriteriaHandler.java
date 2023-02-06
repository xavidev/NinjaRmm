package com.ninjaone.rmm.devices.application.find;

import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.query.QueryHandler;

@Service
public final class FindDeviceByCriteriaHandler implements QueryHandler<FindDeviceByCriteriaQuery, DeviceResponse> {
    private final DevicePerCriteriaFinder finder;

    public FindDeviceByCriteriaHandler(DevicePerCriteriaFinder finder) {
        this.finder = finder;
    }

    @Override
    public DeviceResponse handle(FindDeviceByCriteriaQuery query) {

        return finder.find(query.type());
    }
}
