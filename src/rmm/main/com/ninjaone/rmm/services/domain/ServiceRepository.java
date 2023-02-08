package com.ninjaone.rmm.services.domain;

import com.ninjaone.rmm.services.domain.model.ServiceInformation;
import com.ninjaone.rmm.services.domain.model.ServiceId;
import com.ninjaone.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    void save(ServiceInformation serviceInformation);

    List<ServiceInformation> matching(Criteria criteria);

    Optional<ServiceInformation> search(ServiceId id);

    void delete(ServiceInformation serviceInformation);
}
