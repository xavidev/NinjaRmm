package com.ninjaone.rmm.costs.domain.model;

import java.util.Objects;

public class CostPolicy {

    private String id;
    private String serviceId;
    private double cost;
    private String type;
    private String value;

    public CostPolicy(String id, String serviceId, double cost, String type, String value) {
        this.id = id;
        this.serviceId = serviceId;
        this.cost = cost;
        this.type = type;
        this.value = value;
    }

    public static CostPolicy assignTo(String id, String serviceId, double cost, String policyType, String policyValue) {
        return new CostPolicy(id, serviceId, cost, policyType, policyValue);
    }

    public String id() {
        return id;
    }

    public double cost() {
        return cost;
    }

    public String type() {
        return type;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CostPolicy that = (CostPolicy) o;
        return cost == that.cost && Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, type, value);
    }
}
