package com.ninjaone.rmm.bills.application.createbillexplanation;

import com.ninjaone.rmm.bills.domain.BillItemRepository;
import com.ninjaone.rmm.bills.domain.model.BillExplanation;
import com.ninjaone.rmm.bills.domain.model.BillItem;
import com.ninjaone.shared.domain.Service;

import java.util.List;

@Service
public final class BillExplanationCreator {
    private final BillItemRepository billItemRepository;

    public BillExplanationCreator(BillItemRepository billItemRepository) {

        this.billItemRepository = billItemRepository;
    }

    public BillExplanationResponse create(String customerId) {
        List<BillItem> items = billItemRepository.findAllByCustomerId(customerId);

        BillExplanation bill = BillExplanation.create(customerId, items);

        return new BillExplanationResponse(bill.explain());
    }
}
