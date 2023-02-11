package com.ninjaone.rmm.bills.infrastructure.persistence;

import com.ninjaone.rmm.bills.domain.BillItemMother;
import com.ninjaone.rmm.bills.domain.model.BillItemId;
import com.ninjaone.rmm.bills.infrastructure.BillModuleInfrastructureTestCase;
import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import com.ninjaone.rmm.shared.domain.CustomerIdMother;
import com.ninjaone.rmm.shared.domain.ServiceIdMother;
import org.junit.jupiter.api.Test;

class MySqlBillItemRepositoryShould extends BillModuleInfrastructureTestCase {

    @Test
    void save_bill_item() {
        repository.save(BillItemMother.fromService(
            ServiceIdMother.random(),
            ServiceInformationMother.random(),
            CustomerIdMother.random()
            ));
    }
}
