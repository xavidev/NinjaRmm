package com.ninjaone.rmm.bills.domain.costcalculation;

public final class CalculationParams {
    private String customerId;
    private String serviceId;
    private String deviceId;
    private String type;

    public CalculationParams(String customerId, String serviceId, String deviceId, String type) {

        this.customerId = customerId;
        this.serviceId = serviceId;
        this.deviceId = deviceId;
        this.type = type;
    }

    public String customerId() {
        return customerId;
    }

    public String serviceId() {
        return serviceId;
    }

    public String deviceId() {
        return deviceId;
    }

    public String deviceType() {
        return type;
    }
}


