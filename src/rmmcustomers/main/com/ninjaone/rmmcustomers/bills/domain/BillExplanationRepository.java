package com.ninjaone.rmmcustomers.bills.domain;

import com.ninjaone.rmmcustomers.bills.domain.model.BillExplanation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface  BillExplanationRepository extends JpaRepository<BillExplanation, UUID> {
}
