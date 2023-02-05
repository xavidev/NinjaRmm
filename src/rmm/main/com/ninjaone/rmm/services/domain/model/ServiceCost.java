package com.ninjaone.rmm.services.domain.model;

public final class ServiceCost {
    private ServiceCostId id;
    private String deviceType;
    private double cost;

    private Service service;

    private ServiceCost() {

    }

    private ServiceCost(ServiceCostId costId, double cost, String deviceType) {
        this.id = costId;
        this.cost = cost;
        this.deviceType = deviceType;
    }

    public static ServiceCost create(String costId, double cost, String deviceType) {

        return new ServiceCost(new ServiceCostId(costId), cost, deviceType);
    }

    public void assignTo(Service service) {
        this.service = service;
    }
}
