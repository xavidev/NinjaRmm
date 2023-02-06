package com.ninjaone.rmm.devices.application.find;

import com.ninjaone.rmm.devices.application.DeviceResponse;
import com.ninjaone.rmm.devices.domain.DeviceRepository;
import com.ninjaone.rmm.devices.domain.DeviceTypeNotExistException;
import com.ninjaone.rmm.devices.domain.model.DeviceType;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.criteria.*;

import java.util.ArrayList;
import java.util.List;

@Service
public final class DevicePerCriteriaFinder {
    private final DeviceRepository repository;

    public DevicePerCriteriaFinder(DeviceRepository repository) {
        this.repository = repository;
    }

    public DeviceResponse find(String type) {

        List<Filter> filters = new ArrayList<>();
        filters.add(Filter.create("deviceType", FilterOperator.EQUAL.value(), type));

        var device = repository.matching(new Criteria(new Filters(filters), Order.none()))
            .stream()
            .findFirst()
            .orElseThrow(() -> new DeviceTypeNotExistException(new DeviceType(type)));

        return new DeviceResponse(device.type());
    }
}
