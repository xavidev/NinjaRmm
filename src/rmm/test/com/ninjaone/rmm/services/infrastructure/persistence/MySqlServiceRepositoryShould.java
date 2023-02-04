package com.ninjaone.rmm.services.infrastructure.persistence;

import com.ninjaone.rmm.services.ServicesModuleInfrastructureTestCase;
import com.ninjaone.rmm.services.domain.ServiceMother;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class MySqlServiceRepositoryShould extends ServicesModuleInfrastructureTestCase {

    @Test
    void save_a_service() {
        var service = ServiceMother.random();

        mySqlCourseRepository.save(service);
    }
}
