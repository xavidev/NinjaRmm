USE rrm;
CREATE TABLE IF NOT EXISTS services (
    id       CHAR(36)     NOT NULL,
    name     VARCHAR(255) NOT NULL,
    price     DOUBLE,
    service_costs   JSON    NOT NULL,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS devices (
    id       CHAR(36)     NOT NULL,
    type     VARCHAR(255) NOT NULL,
    price     DOUBLE,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS services_cost (
    id       CHAR(36)     NOT NULL,
    serviceId     CHAR(36)     NOT NULL,
    deviceId     CHAR(36)     NOT NULL,
    customerId     CHAR(36)     NOT NULL,
    name     CHAR(36)     NOT NULL,
    price     DOUBLE,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS devices_cost (
    id       CHAR(36)     NOT NULL,
    deviceId     CHAR(36)     NOT NULL,
    customerId     CHAR(36)     NOT NULL,
    price     DOUBLE,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


