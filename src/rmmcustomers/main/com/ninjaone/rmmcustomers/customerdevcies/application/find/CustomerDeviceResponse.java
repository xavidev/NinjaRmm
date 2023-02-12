package com.ninjaone.rmmcustomers.customerdevcies.application.find;

import com.ninjaone.shared.domain.bus.query.Response;

import java.util.List;

public final class CustomerDeviceResponse implements Response {

    private String systemName;
    private String deviceType;
    private List<String> services;

    private String totalCost;

    public CustomerDeviceResponse(String systemName, String deviceType, List<String> services, String totalCost) {
        this.systemName = systemName;
        this.deviceType = deviceType;
        this.services = services;
        this.totalCost = totalCost;
    }

    public String getSystemName() {
        return systemName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public List<String> getServices() {
        return services;
    }

    public String getTotalCost() {
        return totalCost;
    }
}
