package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    void save(Service service);

    List<Service> matching(Criteria criteria);

    Optional<Service> search(ServiceId id);
}
