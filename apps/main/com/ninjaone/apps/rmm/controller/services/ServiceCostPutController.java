package com.ninjaone.apps.rmm.controller.services;

import com.ninjaone.rmm.services.application.assigncost.ServiceCostPolicyAssigner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ServiceCostPutController {

    private final ServiceCostPolicyAssigner costAsigner;

    public ServiceCostPutController(ServiceCostPolicyAssigner costAsigner) {
        this.costAsigner = costAsigner;
    }
    @PutMapping("/services/{id}/cost")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody ServiceCostRequest request) {

        this.costAsigner.assign(id, request.cost(), request.deviceType());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}

final class ServiceCostRequest {
    private String deviceType;
    private double cost;

    public String deviceType() {
        return deviceType;
    }

    public double cost() {
        return cost;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
