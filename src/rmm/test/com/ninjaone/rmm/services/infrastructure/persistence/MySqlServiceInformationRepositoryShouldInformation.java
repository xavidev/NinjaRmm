package com.ninjaone.rmm.services.infrastructure.persistence;

import com.ninjaone.rmm.services.ServicesModuleInfrastructureTestCase;
import com.ninjaone.rmm.services.domain.ServiceCostPolicyMother;
import com.ninjaone.rmm.services.domain.ServiceMother;
import com.ninjaone.shared.domain.ServiceId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class MySqlServiceInformationRepositoryShouldInformation extends ServicesModuleInfrastructureTestCase {

    @Test
    void save_a_service() {
        var service = ServiceMother.random();
        service.addCostPolicy(ServiceCostPolicyMother.random());
        service.addCostPolicy(ServiceCostPolicyMother.random());

        mySqlCourseRepository.save(service);
    }
    @Test
    void get_a_service() {
        var service = ServiceMother.random();
        service.addCostPolicy(ServiceCostPolicyMother.random());
        service.addCostPolicy(ServiceCostPolicyMother.random());

        mySqlCourseRepository.save(service);

        var found = mySqlCourseRepository.search(new ServiceId(service.id()));

        Assertions.assertEquals(service, found.get());
    }
}
