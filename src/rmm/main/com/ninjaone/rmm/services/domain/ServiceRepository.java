package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.Service;
import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;

public interface ServiceRepository {
    void save(Service service);

    List<Service> matching(Criteria criteria);
}
