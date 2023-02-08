package com.ninjaone.rmmcustomers.bills.application.createbillexplanation;

import com.ninjaone.rmmcustomers.bills.domain.BillExplanationRepository;
import com.ninjaone.rmmcustomers.bills.domain.BillItemRepository;
import com.ninjaone.rmmcustomers.bills.domain.model.BillExplanation;
import com.ninjaone.rmmcustomers.bills.domain.model.BillItem;
import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.bus.event.EventBus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public final class BillExplanationCreator {
    private final BillExplanationRepository billExplanationRepository;
    private final BillItemRepository billItemRepository;
    private final EventBus bus;

    public BillExplanationCreator(BillExplanationRepository billExplanationRepository, BillItemRepository billItemRepository, EventBus bus) {

        this.billExplanationRepository = billExplanationRepository;
        this.billItemRepository = billItemRepository;
        this.bus = bus;
    }

    public void create(String customerId) {
        List<BillItem> items = billItemRepository.findAllByCustomerId(customerId);

        Optional<BillExplanation> optional = billExplanationRepository.findById(UUID.fromString(customerId));

        BillExplanation bill;
        if (optional.isPresent()) {
            bill = optional.get();
            bill.recreateFrom(items);
        } else {
            bill = BillExplanation.create(customerId, items);
            billExplanationRepository.save(bill);
        }

        bus.publish(bill.pullDomainEvents());
    }
}
