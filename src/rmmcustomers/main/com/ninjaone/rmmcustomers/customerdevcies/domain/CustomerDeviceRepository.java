package com.ninjaone.rmmcustomers.customerdevcies.domain;

import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDevice;
import com.ninjaone.rmmcustomers.customerdevcies.domain.model.CustomerDeviceId;
import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface  CustomerDeviceRepository {

    void save(CustomerDevice device);

    Optional<CustomerDevice> search(CustomerDeviceId customerDeviceId);

    List<CustomerDevice> match(Criteria criteria);
}
