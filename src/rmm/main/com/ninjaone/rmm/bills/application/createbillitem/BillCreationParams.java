package com.ninjaone.rmm.bills.application.createbillitem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BillCreationParams {
    private String orderId;

    private String orderConcept;
    private String deviceId;
    private String serviceId;
    private String customerId;
    private String itemType;
}
