package com.ninjaone.rmm.services.domain.model;

public final class ServiceCostPolicy {
    private ServiceCostId id;
    private String deviceType;
    private double cost;

    private Service service;

    private ServiceCostPolicy() {

    }

    private ServiceCostPolicy(ServiceCostId costId, double cost, String deviceType) {
        this.id = costId;
        this.cost = cost;
        this.deviceType = deviceType;
    }

    public static ServiceCostPolicy create(String costId, double cost, String deviceType) {

        return new ServiceCostPolicy(new ServiceCostId(costId), cost, deviceType);
    }

    public void assignTo(Service service) {
        this.service = service;
    }

    public String id() {
        return id.value();
    }

    public String deviceType() {
        return deviceType;
    }

    public double cost() {
        return cost;
    }

}
