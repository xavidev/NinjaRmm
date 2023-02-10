package com.ninjaone.rmm.services.infrastructure.persistence;

import com.ninjaone.rmm.services.ServicesModuleInfrastructureTestCase;
import com.ninjaone.rmm.services.domain.ServiceCostPolicyMother;
import com.ninjaone.rmm.services.domain.ServiceInformationMother;
import com.ninjaone.rmm.shared.domain.ServiceId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class MySqlServiceInformationRepositoryShould extends ServicesModuleInfrastructureTestCase {

    @Test
    void save_a_service() {
        var service = ServiceInformationMother.random();
        service.addCostPolicy(ServiceCostPolicyMother.random());
        service.addCostPolicy(ServiceCostPolicyMother.forSameServices("antivirus", "3", "30"));

        mySqlCourseRepository.save(service);
    }
    @Test
    void get_a_service() {
        var service = ServiceInformationMother.random();
        service.addCostPolicy(ServiceCostPolicyMother.random());
        service.addCostPolicy(ServiceCostPolicyMother.forSameServices("antivirus", "3", "30"));

        mySqlCourseRepository.save(service);

        var found = mySqlCourseRepository.search(new ServiceId(service.id()));

        Assertions.assertEquals(service, found.get());
    }
}
