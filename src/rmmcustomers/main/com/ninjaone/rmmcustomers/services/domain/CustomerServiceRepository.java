package com.ninjaone.rmmcustomers.services.domain;

import com.ninjaone.rmmcustomers.services.domain.model.CustomerService;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerServiceRepository extends CrudRepository<CustomerService, UUID> {
}
