package com.ninjaone.rmm.bills.domain;

import com.ninjaone.rmm.bills.domain.model.BillItem;
import com.ninjaone.rmm.bills.domain.model.BillItemId;
import com.ninjaone.rmm.bills.domain.model.BillItemInfo;
import com.ninjaone.rmm.devices.domain.model.DeviceInformation;
import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.shared.domain.Price;

public final class BillItemMother {
    public static BillItem fromDevice(String id, DeviceInformation device, String customerID) {
        return BillItem.create(
            new BillItemId(id),
            new BillItemInfo(device.type(), "device", customerID),
            new Price(String.valueOf(device.cost()))
            );
    }

    public static BillItem fromService(String id, ServiceInformation service, String customerId) {
        return BillItem.create(
            new BillItemId(id),
            new BillItemInfo(service.name(), "service", customerId),
            new Price(String.valueOf(service.cost()))
        );
    }
}
