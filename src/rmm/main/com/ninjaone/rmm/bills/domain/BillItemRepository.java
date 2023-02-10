package com.ninjaone.rmm.bills.domain;

import com.ninjaone.rmm.bills.domain.model.BillItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BillItemRepository extends JpaRepository<BillItem, UUID> {
    List<BillItem> findAllByCustomerId(String customerId);
}
