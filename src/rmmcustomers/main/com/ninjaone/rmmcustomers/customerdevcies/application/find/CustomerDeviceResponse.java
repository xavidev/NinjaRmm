package com.ninjaone.rmmcustomers.customerdevcies.application.find;

import com.ninjaone.shared.domain.bus.query.Response;

import java.util.List;

public final class CustomerDeviceResponse implements Response {

    private String systemName;
    private String deviceType;
    private List<String> services;

    private String totalCost;
}
