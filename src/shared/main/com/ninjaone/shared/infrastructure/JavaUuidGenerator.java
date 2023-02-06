package com.ninjaone.shared.infrastructure;

import com.ninjaone.shared.domain.Service;
import com.ninjaone.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
